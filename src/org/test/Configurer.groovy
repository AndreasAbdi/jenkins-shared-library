package org.test


class Configurer {
    public static configure() {
        def triggerFrequency = "H 4 * * *"
        def propertiesList = []
        def pipelineTriggersList = []
        pipelineTriggersList.add(cron(triggerFrequency))
        propertiesList.add(pipelineTriggers(pipelineTriggersList))
        properties(propertiesList)
    }
}