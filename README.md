# Student Management System (Abiturient GUI)

A JavaFX-based desktop application for managing student information and generating statistics. This system allows users to maintain records of students/graduates with their passport details, specialty codes, education forms, and payment types.

## Features

- **Student Record Management**: Add, edit, and delete student records
- **Data Fields**: 
  - Passport number
  - Specialty code
  - Education form (Full-time/Part-time)
  - Payment type (Budget/Commercial)
- **Search Functionality**: Real-time search across all student data fields
- **Statistical Reports**: Generate comprehensive statistics by specialty, education form, and payment type
- **File Operations**: Import and export student data to/from text files
- **Modern UI**: Clean interface using JMetro styling

## Screenshots

<img src="https://github.com/nayutalienx/abiturient_gui/blob/master/1.png" alt="Student Management System Interface" border="0">

*Main interface showing student records table with action buttons, search functionality, and input forms*

## Technology Stack

- **Language**: Java
- **UI Framework**: JavaFX
- **Styling**: JMetro 5.5
- **Architecture**: MVC (Model-View-Controller)
- **Build Tool**: IntelliJ IDEA project structure

## System Requirements

- Java 8 or higher
- JavaFX runtime (included in Java 8, separate module in Java 11+)
- JMetro library

## Installation and Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/nayutalienx/abiturient_gui.git
   cd abiturient_gui
   ```

2. **Open in IDE**:
   - Import the project in IntelliJ IDEA
   - Ensure JMetro library is properly configured (already included in project settings)

3. **Build and Run**:
   - Compile the project using your IDE's build system
   - Run the `Main.java` class to start the application
   - Alternatively, use the pre-built JAR file in `out/artifacts/_jar/prg.jar`

## Usage

### Adding Students
1. Fill in the form at the bottom of the window:
   - Enter passport number (format: XXXXYYYYYY)
   - Enter specialty code
   - Select education form (Full-time/Part-time)
   - Select payment type (Budget/Commercial)
2. Click "Add" button to add the student to the table

### Managing Records
- **Edit**: Click "Edit" link in the Actions column to modify student information
- **Delete**: Click "Delete" link in the Actions column to remove a student record

### Search
- Use the search box in the top-right corner to filter students by any field
- Search works in real-time as you type

### Statistics
- Click "General Statistics" button to view detailed reports
- Statistics include breakdown by specialty, education form, and payment type

### File Operations
- **File → Open**: Import student data from a text file
- **File → Save**: Export current student data to a text file
- **File → Exit**: Close the application

## Project Structure

```
src/sample/
├── Main.java              # Main application class
├── Controller.java        # Main window controller
├── Graduate.java          # Student data model
├── EditWindow.java        # Edit dialog window
├── EditController.java    # Edit dialog controller
├── StatisticWindow.java   # Statistics display window
├── StatisticController.java # Statistics controller
├── main.fxml             # Main window layout
├── editor.fxml           # Edit dialog layout
├── statistic.fxml        # Statistics window layout
└── style.css             # Additional styling
```

## Data Format

The application uses space-separated text files for data import/export:
```
PassportNumber SpecialtyCode EducationForm PaymentType
```

Example:
```
1234567890 CS-101 Full-time Budget
0987654321 EE-201 Part-time Commercial
```

## Development Notes

This project was developed as a coursework assignment for Programming Languages and Methods course by Mosenkov V.A. The application demonstrates:
- JavaFX GUI development
- MVC architecture implementation
- File I/O operations
- Data management and filtering
- Statistical data processing

## License

This project is available for educational and reference purposes.
