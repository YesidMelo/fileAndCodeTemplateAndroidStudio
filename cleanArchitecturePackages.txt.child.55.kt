package ${PACKAGE_NAME}.sources.cache

class Cache {
    var listenerExceptionsLiveData: Any? = null
    companion object {
        private val instance = Cache()
        fun getInstance() = instance
    }
}