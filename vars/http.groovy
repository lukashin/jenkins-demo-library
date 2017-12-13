def verify(String url, present = '', notPresent = '') {
    def response = (new URL(url.trim())).text

    assert response

    if (present) {
        if (present instanceof String) {
            present = [present]
        }
        present.each {
            assert response.contains(it)
        }
    }

    if (notPresent) {
        if (notPresent instanceof String) {
            notPresent = [notPresent]
        }
        notPresent.each {
            assert !response.contains(it)
        }
    }
}

def download(String url) {
    return (new URL(url)).text.trim()
}
