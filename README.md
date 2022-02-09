# Clear Score Application

An android app built using Kotlin that display credit score.It has been built following SOLID Principle, Repository Pattern, MVVM Architecture in the presentation layer as well as Jetpack components.


## Table Of Content.
    - [Libraries](##libraries)
    - [Future modification](##Future modification)





## Libraries.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    - [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)-Component that allows easier implementation of navigation from simple button clicks to more complex patterns.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client
  and supports coroutines out of the box.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse
  requests on the data layer for Entities and understands Kotlin non-nullable
  and default parameters.
- [View binding(Android Jetpack)](https://developer.android.com/topic/libraries/view-binding)-View binding is a feature that allows you to more easily write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [RX java](https://reactivex.io) - RxJava is a Java library that enables Functional Reactive Programming in Android development. It raises the level of abstraction around threading in order to simplify the implementation of complex concurrent behavior.
- [Material Design](https://material.io/develop/android/docs/getting-started/) - Build awesome beautiful UIs.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides runBlocking coroutine builder used in tests.


# Future modifications
If i had more time i would have designed user login page and get relevant credit score for the user.The credit score would be retrieved from the server to get a user information data.
-User notifications if the credit score has changed to check for new offers. 

 ProgressBar pieChart = binding.statsProgressBar;
double d = (double) calsBurned / (double) calsConsumed;
    int progress = (int) (d * 100);
    pieChart.setProgress(progress);
