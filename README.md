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

### Data

In the data package there are 3 subpackage : 

### Local
It contains all the data that will be used locally for the storage

### Remote
It contains all the data needed to store the response for the API

### Mappers
The mappers package allows to convert from Remote data to Local data
and from Local data to Model data (used in the UI)

### DI
Contains the AppModule to provide the ApiService, the Database and the 
pager.

### Domain
Contains the data class representing the ArtObject that will be used
across the UI

### Presentation
Contains everything related to the UI : Screens and ViewModel

### External Libraries

- Kotlinx serialization : to get Kotlin object from JSON
- Retrofit : to make network request
- Room : to save data locally
- Dagger Hilt : for dependencies injection 
- Paging : to handle pagination
- Coil Compose : to display image inside a composable
- LiveData : to observe data to update the UI

### Data

In the data package there are 3 subpackage : 

### Local
It contains all the data that will be used locally for the storage

### Remote
It contains all the data needed to store the response for the API

### Mappers
The mappers package allows to convert from Remote data to Local data
and from Local data to Model data (used in the UI)

## Screenshots


<p float="left">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_1.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_2.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_3.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/dark_4.png" width="480" height="1040">
</p>

<p float="left">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_1.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_2.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_3.png" width="480" height="1040">
  <img src="https://github.com/mrxx0/RijksMuseum/blob/main/screenshots/light_4.png" width="480" height="1040">
</p>
