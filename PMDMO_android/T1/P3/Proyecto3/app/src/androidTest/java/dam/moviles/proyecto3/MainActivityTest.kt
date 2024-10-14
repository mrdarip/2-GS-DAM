package dam.moviles.proyecto3

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario:ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun test1(){
        onView(withId(R.id.chrClock))
            .check(matches(withText("00:00")))
    }

    @Test
    fun test2(){
        onView(withId(R.id.btnStart))
            .check(matches(isEnabled()))

        listOf(
            R.id.btnStop,
            R.id.btnReiniciar,
            R.id.btnStop
        ).forEach{id ->
            onView(withId(id))
                .check(matches(isNotEnabled()))
        }
    }

    @Test
    fun test3(){
        onView(withId(R.id.btnStart))
            .perform(click())
            .check(matches(isNotEnabled()))

        listOf(
            R.id.btnStop,
            R.id.btnReiniciar,
            R.id.btnStop
        ).forEach{id ->
            onView(withId(id))
                .check(matches(isEnabled()))
        }
    }

    @Test
    fun test4(){
        onView(withId(R.id.btnStart))
            .perform((click()))
        Thread.sleep(5000)

        onView(withId(R.id.chrClock))
            .check(matches(withText("00:05")))
    }

    /*@Test
    fun test5(){
        onView(withId(R.id.btnStart)).perform(click())

        Thread.sleep(5000)

        scenario.recreate()
        onView(withId(R.id.chrClock))
            .check()

    }*/
}