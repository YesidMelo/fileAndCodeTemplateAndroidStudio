package ${PACKAGE_NAME}.di.sources

import ${PACKAGE_NAME}.sources.cache.Cache
import dagger.Module
import dagger.Provides

@Module
class CacheModule {

    @Provides
    fun providesMemoriaCache(): Cache = Cache.getInstance()

}