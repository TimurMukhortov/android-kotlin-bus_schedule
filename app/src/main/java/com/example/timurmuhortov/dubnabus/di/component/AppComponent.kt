package com.example.timurmuhortov.dubnabus.di.component

import android.content.Context
import com.example.timurmuhortov.dubnabus.DubnabusApplication
import com.example.timurmuhortov.dubnabus.di.module.*
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * @author: timur.mukhortov
 * date: 29.01.2018
 * time: 2:17
 * @LinkedIn: linkedin.com/in/timurmukhortov
 **/

@Singleton
@Component(modules = [
    (AppModule::class),
    (RouterModule::class),
    (RealmModule::class),
    (RepositoryModule::class),
    (UtilModule::class),
    (NetworkModule::class)
])
interface AppComponent {

    /*
    *
    * Дает нам синтаксический сахар.
    * Мы можем сделать так:
    *   DaggerAppComponent
    *       .builder()
    *       .context(this)
    *       .build()
    *       .inject(this)
    *
    * после чего у нас может вообще не быть instanc(a) наших модулей,
    * которые мы передаем в приложение;
    *
    * Теперь Application будет просто добавленно в наш app граф.
    *
    * У Builder(a) есть некоторые правила:
    *   - Должен существовать один абстрактный метод без аргументов и возвращаться AppComponent.
    *   Обычно это build() метод;
    *
    *   - Все остальные абстрактные методы должны принимать один аргумент и возвращать:
    *      void || Builder || super type of Builder;
    *
    *   - Каждая зависимость от компонента должна иметь абстрактный метод setter;
    *
    *   - Каждая зависимость, которую Dagger не может создать самостоятельно
    *   (Например: модуль не имеет видимого конструктора no-args)
    *   должен иметь абстрактный setter метод. Другие зависимости модулей
    *   (те, которые может создать экземпляр Dagger), разрешены, но не требуются;
    *
    *   - Не абстрактные методы разрешены, но игнорируются
    *   в отношении валидации и builder generation are concerned.
    *
    */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(application: DubnabusApplication)
}