# RijksMuseum
An Android app to display items from the Rijks museum

## Installation

Clone the repository

```bash
git clone https://github.com/mrxx0/RijksMuseum.git
```
Inside the cloned repository at the root of the directory you will need a ``local.properties`` file.
In this file you must at this line : 

```bash
MUSEUM_API_KEY="YOUR_API_KEY"
```

- Open the project in Android Studio.
- Build it
- Run it !

## Architecture

This project is structured following the MVVM architecture.

### Why ?

- Better maintainability 
- Seperate the UI code base from the logic codebase
- Lifecycle management on configuration change (like screen rotation)

## External Libraries

- Kotlinx serialization : to get Kotlin object from JSON
- Retrofit : to make network request
- Room : to save data locally
- Dagger Hilt : for dependencies injection 
- Paging : to handle pagination
- Coil Compose : to display image inside a composable
- LiveData : to observe data to update the UI

## Screenshots


<p float="left">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_1.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_2.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_3.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_4.png" width="240" height="520">
</p>

<p float="left">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_1.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_2.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_3.png" width="240" height="520">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_4.png" width="240" height="520">
</p>
