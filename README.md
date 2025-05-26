# Flash Card App (ST10477052_Flash_Card_App)

A simple Android application that presents users with a series of true/false basic mathematics questions. The app tracks the user's score and displays it on a results screen.

## Features

*   **Welcome Screen (`MainActivity`):**
    *   Displays a welcome message and a brief description of the app.
    *   A "Start" button to navigate to the flash card quiz.
*   **Flash Card Screen (`FlashCardScreen`):**
    *   Presents a series of predefined mathematics questions one by one.
    *   Users can answer "TRUE" or "FALSE" for each question.
    *   Provides immediate feedback (Toast message) if the answer is correct or incorrect.
    *   Tracks the user's score.
    *   A "Next Page" button (enabled after all questions are answered) to navigate to the results screen.
*   **Results Screen (`FlashResultSCreen`):**
    *   Displays the user's final score (e.g., "Your Score: X / Y").

## Code Structure

The application is primarily composed of three activities:

1.  **`MainActivity.kt`** (`res/layout/activity_main.xml`)
    *   Serves as the entry point and welcome screen.
    *   Handles navigation to the `FlashCardScreen`.

2.  **`FlashCardScreen.kt`** (`res/layout/activity_flash_card_screen.xml`)
    *   Manages the quiz logic:
        *   Stores questions (`questionArray`) and their corresponding answers (`answerArray`).
        *   Tracks the current question index (`currentNumber`) and the user's score (`counter`).
        *   Updates the UI to display the current question.
        *   Handles user input from "TRUE" and "FALSE" buttons.
        *   Navigates to `FlashResultSCreen` when the quiz is complete and the "Next Page" button is clicked, passing the score and total questions.

3.  **`FlashResultSCreen.kt`** (`res/layout/activity_flash_result_screen.xml`)
    *   Receives the user's score and the total number of questions from `FlashCardScreen` via Intent extras.
    *   Displays the final score to the user.

## Key Android Concepts Used

*   **Activities:** `AppCompatActivity` is used as the base class for all screens.
*   **Layouts (XML):** UI is defined using XML layouts in the `res/layout` directory (e.g., `activity_main.xml`, `activity_flash_card_screen.xml`, `activity_flash_result_screen.xml`). `ConstraintLayout` and `LinearLayout` are used for arranging UI elements.
*   **Views:** Standard Android UI elements like `TextView`, `Button`, `ImageView`.
*   **`findViewById`:** Used to get references to UI elements defined in XML.
*   **`setOnClickListener`:** Used to handle button clicks.
*   **`Intent`:** Used for navigating between Activities and passing data (score, total questions) between them using `putExtra()`.
*   **`Toast`:** Used for providing short feedback messages to the user.
*   **`enableEdgeToEdge` & `ViewCompat.setOnApplyWindowInsetsListener`:** Used to implement an edge-to-edge display, allowing the app content to draw behind system bars with appropriate padding.
*   **String Arrays:** Used in `FlashCardScreen` to store the questions and answers.
*   **`lateinit`:** Used for non-null view properties that are initialized in `onCreate`.
*   **`AndroidManifest.xml`:** Declares all activities and sets the launcher activity.

## How to Build and Run

1.  **Clone the repository (if applicable) or open the project in Android Studio.**
2.  **Ensure you have the Android SDK installed and configured in Android Studio.**
3.  **Connect an Android device or start an Android Emulator.**
4.  **In Android Studio, click the "Run" button (green play icon) or use the shortcut (Shift + F10).**

## Screenshots (Optional)

*(You can add screenshots of your app's main screens here if you want)*

*   *Welcome Screen*
*   *Flash Card Question Screen*
*   *Results Screen*

## Future Improvements (Optional)

*   Add more varied question types.
*   Implement better UI/UX design.
*   Persist high scores.
*   Add different difficulty levels.
*   Randomize question order.

## Author

*   Sohan Ashmith Maharaj /  ST10477052

---

This README provides a good starting point. Remember to:

1.  **Replace placeholders:** Like `com.example.myapplication` with your actual package name (though from our chat it's `com.example.st10477052flashcardapp`), and add your name/ID.
2.  **Verify XML file names:** Ensure the XML layout file names mentioned match exactly what you have in `res/layout/`.
3.  **Add screenshots:** Visuals make a README much more engaging.
4.  **Expand sections:** Add more detail if you think it's necessary, especially if there are any unique aspects to your implementation.
5.  **Git:** If you are using Git, commit this `README.md` file to your repository.
