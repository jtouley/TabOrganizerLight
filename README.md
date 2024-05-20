# TabOrganizerLight

TabOrganizerLight is an Android app designed to help users view and manage their open tabs in the Chrome browser. This project was inspired by a comment from Ryan H, which led to the exploration of developing an app that accesses and organizes browser tabs.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Challenges](#challenges)
- [Lessons Learned](#lessons-learned)
- [Contributing](#contributing)
- [License](#license)

## Introduction

TabOrganizerLight aims to provide an intuitive interface for users to view and manage their open tabs in the Chrome browser on Android. The app was built with the intention of leveraging Android's content provider to access browser bookmarks and tabs.

## Features

- Simple and intuitive UI with a button to fetch open tabs.
- Displays the URLs of currently open tabs in the Chrome browser.
- Handles permissions dynamically to access browser data.

## Setup

To set up the project locally, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/TabOrganizerLight.git
    cd TabOrganizerLight
    ```

2. Open the project in Android Studio.

3. Build the project to download dependencies.

4. Run the app on an Android device or emulator.

## Usage

1. Launch the TabOrganizerLight app.

2. Press the "Get Open Tabs" button to fetch the list of open tabs.

3. If prompted, grant the necessary permissions to access browser data.

## Challenges

During the development of TabOrganizerLight, we encountered significant challenges, particularly with Android's permissions. Accessing browser bookmarks and open tabs is restricted by Google's security policies, which prevent apps from reading this data without the appropriate permissions.

Despite our efforts to handle permissions dynamically, the app cannot function as intended due to these restrictions. This limitation underscores the importance of understanding platform constraints and navigating security policies in app development.

## Lessons Learned

This project has been a humbling and enlightening experience. Key takeaways include:

- The critical role of permissions and security policies in app development.
- The importance of thorough research and understanding of platform limitations.
- Resilience and adaptability in the face of unexpected challenges.

While the app does not fully achieve its original goal, the development process has provided valuable insights into Android development and security considerations.

## Contributing

We welcome contributions to enhance TabOrganizerLight. If you have suggestions or improvements, please open an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch:
    ```bash
    git checkout -b feature/your-feature
    ```
3. Make your changes and commit them:
    ```bash
    git commit -m "Add new feature"
    ```
4. Push to the branch:
    ```bash
    git push origin feature/your-feature
    ```
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
