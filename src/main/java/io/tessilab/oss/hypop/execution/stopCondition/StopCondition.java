/*
 * Copyright 2017 Tessi lab.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.tessilab.oss.hypop.execution.stopCondition;

import io.tessilab.oss.hypop.execution.BlockConfiguration;
import io.tessilab.oss.hypop.results.ProcessResult;
import io.tessilab.oss.openutils.designpatterns.observer.ParametrizedObserver;

/**
 * A class to add another (than the default {@link io.tessilab.oss.hypop.parameters.managers.ParametersManager#hasJobsToExplore() }) 
 * stop conditions to the hyperparameter research execution.
 * 
 * @author Andres BEL ALONSO
 * @param <SCORE> The score of the quality of an execution
 * @param <PROCESSRESULT> The class containing all the information about a process result
 */
public abstract class StopCondition<SCORE extends Comparable<SCORE>,
        PROCESSRESULT extends ProcessResult<SCORE>> implements ParametrizedObserver<PROCESSRESULT>{
    
    public static abstract class Config<SCORE extends Comparable<SCORE>,PROCESSRESULT extends ProcessResult<SCORE>>
            extends BlockConfiguration<StopCondition<SCORE,PROCESSRESULT>> {
        
    }
    
    /**
     * @return true if the stop condition has NOT been reached
     */
    public abstract boolean continueWork();
    
    /**
     * 
     * @return An estimation of the number of jobs to do
     */
    public abstract int getJobsToDo();
    
}
