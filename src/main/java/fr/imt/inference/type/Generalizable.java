package fr.imt.inference.type;

import fr.imt.inference.Environment;
import fr.imt.logger.Logger;
import fr.imt.logger.LoggerFactory;
import io.vavr.collection.Set;

/**
 * Not an interface as it cannot be used outside of a type
 * but it represents the way we can generalize from a type
 */
public abstract class Generalizable implements Type {
    
    private final Logger logger = LoggerFactory.getConsoleLogger();

    @Override
    public Scheme generalize(Environment environment) {
        Set<TypeVariable> typeFTV = this.getFreeTypeVariables();
        Set<TypeVariable> envFTV = environment.getFreeTypeVariables();

        Set<TypeVariable> notEnvironmentBoundedTypeVariables = typeFTV.diff(envFTV);

        logger.debug("Generalizing... | (typeFTV => " + typeFTV + ") \\ (envFTV => " + envFTV + ") ==> " + notEnvironmentBoundedTypeVariables);

        return new Scheme(notEnvironmentBoundedTypeVariables, this);
    }
}
