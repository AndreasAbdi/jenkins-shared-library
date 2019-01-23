package org.test
import org.jenkinsci.plugins.workflow.cps.CpsScript


class Configurer implements Serializable {

    private CpsScript script

    public Configurer(CpsScript script) {
        this.script = script
    }

    public void configure() {
        def invokable = {
            def triggerFrequency = "H 4 * * *"
            def propertiesList = []
            def pipelineTriggersList = []
            pipelineTriggersList.add(cron(triggerFrequency))
            propertiesList.add(pipelineTriggers(pipelineTriggersList))
            properties(propertiesList)
        }
        invokable.delegate = this.script
        invokable.resolveStrategy = Closure.DELEGATE_FIRST
        invokable()
    }
}