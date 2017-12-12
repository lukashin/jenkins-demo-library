import groovy.json.JsonSlurper
// GET /repos/:owner/:repo/pulls/:number
// GET /repos/:owner/:repo/issues/:number
// https://github.com/lukashin/jenkins-demo-library/pull/1
// https://developer.github.com/v3/issues/#get-a-single-issue

def labels(pullRequestId) {
    URL apiUrl = new URL("https://api.github.com/repos/lukashin/jenkins-demo-library/issues/${pullRequestId}?access_token=${env.API_KEY}")
    def json = new JsonSlurper().parseText(apiUrl.text)
    if (!json || !json?.labels) {
        return []
    }

    json.labels.collect {
        it.name
    }
}

def hasLabel(pullRequestId, String label) {
    labels(pullRequestId).contains(label)
}
