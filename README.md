HEAD
## Introduction
Greetings Everyone, My name is Aditya and currently I'm working on my project `Study Planner` which is developed using Java language 

## Study Planner
This is a Java application that helps students manage their study schedule. It distributes subjects based on priority. The Study Planner tracks completion progress. The Study Planner is a tool for students.

## Problem Statement
Students struggle to manage time across subjects during exams. Without a plan important subjects get neglected. Time is wasted. The Study Planner generates a study schedule. It lets students track their progress. The Study Planner helps students make the most of their time.

## Features
* Add subjects with hours and priority level, such as High, Medium or Low. This feature is very useful.

* Auto-generate a schedule with subjects distributed intelligently across days. The Study Planner does this well.

* Priority-based scheduling ensures high priority subjects appear across days. This is a feature of the Study Planner.

* Mark tasks as complete to track progress. The Study Planner makes it easy to track progress.

* View a progress report to see the percentage of tasks completed with a message. The Study Planner provides a progress report.

* Data persistence saves the schedule to a file. It reloads it the time the Study Planner is used. The Study Planner saves the schedule to a file called study_data.txt.

## Project Structure
```

StudyPlanner/

├── src/

│   ├──           # Entry point menu

│   ├── Task.java           # Task model, which is the subject, day, hours, priority, status

│   ├── StudyPlanner.java   # Core logic, which is the scheduling, progress tracking

│   ├── UserInput.java      # Handles validation

│   └── FileManager.java    # Loads data from study_data.txt

└── README.md

```

### Prerequisites
* Java JDK 8 or higher installed. The Study Planner needs Java JDK 8 or higher.

* Command. Terminal access. The Study Planner can be run from the command line.

### Steps
```bash

# 1. Clone the repository

git clone https://github.com/YOUR_USERNAME/study-planner.git

cd study-planner/src

# 2. Compile all Java files

javac *.java

# 3. Run the Study Planner application

java Main

```

## Example Usage

```

==========================================

WELCOME TO STUDY PLANNER

==========================================

--- MENU ---

1. Add a subject

2. View weekly schedule

3. Mark task as

4. View progress report

5. Save and Exit

Enter your choice: 1

--- ADD SUBJECT ---

Enter name: Mathematics

Enter hours per week for this subject, which's between 1-30: 10

Enter priority, such as High, Medium or Low: High

Subject added. Mathematics is scheduled for 5 day(s) at 2 hr(s)/day.

```

**Viewing the schedule:**

```

==========================================

YOUR WEEKLY SCHEDULE

==========================================

[ MONDAY ]

[    ] Monday | Mathematics 2 hr(s) Priority: High

[ TUESDAY ]

[    ] Tuesday Mathematics 2 hr(s) Priority: High

[    ] Tuesday | Physics | 1 hr(s) | Priority: Medium

...

```

**After marking tasks:**

```

==========================================

PROGRESS REPORT

================================----------

Total Tasks   : 8

Completed Tasks     : 5

Remaining Tasks     : 3

Completion    : 62%

Halfway there. Keep going.

==========================================

```

## Data Persistence
The Study Planner saves the schedule to a file called study_data.txt in the directory when exiting the Study Planner. The Study Planner reloads the schedule from the file when it runs again. The Study Planner saves the schedule to study_data.txt so progress is never lost.

## Java Concepts Used
| Concept | Where Used |

|---|---|

Object-Oriented Programming, which is Classes and Objects | `Task` `StudyPlanner` `UserInput` `FileManager` |

| ArrayList, which is Collections | Storing and sorting tasks in `StudyPlanner` |

| File Handling | `FileManager` reads and writes `study_data.txt` |

| Exception Handling | Input validation and file I/O errors |

| Sorting, which is Comparator | Priority-based schedule sorting |

## Submitted by:
**Aditya Roshan Singh**

Course: Programming, in Java

Institution: VIT


# 📚 Study Planner

A command-line Java application that helps students manage their weekly study schedule intelligently — by distributing subjects based on priority and tracking completion progress.

---

## 🧩 Problem Statement

Students often struggle to manage time across multiple subjects, especially during exams. Without a structured plan, important subjects get neglected and time is wasted. This tool solves that by generating a personalized weekly study schedule and letting students track their progress.

---

## ✨ Features

- **Add subjects** with total weekly hours and priority level (High / Medium / Low)
- **Auto-generate weekly schedule** — subjects distributed intelligently across days
- **Priority-based scheduling** — High priority subjects appear across more days
- **Mark tasks as complete** — track what you've done
- **Progress report** — see percentage of tasks completed with a motivational message
- **Data persistence** — your schedule is saved to a file and reloaded next session

---

## 🗂️ Project Structure

```
StudyPlanner/
├── src/
│   ├── Main.java           # Entry point, main menu
│   ├── Task.java           # Task model (subject, day, hours, priority, status)
│   ├── StudyPlanner.java   # Core logic: scheduling, progress tracking
│   ├── UserInput.java      # Handles all console input and validation
│   └── FileManager.java    # Saves and loads data from study_data.txt
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Command line / terminal access

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/study-planner.git
cd study-planner/src

# 2. Compile all Java files
javac *.java

# 3. Run the application
java Main
```

---

## 🖥️ Example Usage

```
==========================================
       WELCOME TO STUDY PLANNER          
==========================================

--- MAIN MENU ---
1. Add a subject
2. View weekly schedule
3. Mark task as complete
4. View progress report
5. Save and Exit
Enter your choice: 1

--- ADD SUBJECT ---
Enter subject name: Mathematics
Enter total hours per week for this subject (1-30): 10
Enter priority (High / Medium / Low): High

Subject added! Mathematics scheduled for 5 day(s) at 2 hr(s)/day.
```

**Viewing the schedule:**
```
==========================================
          YOUR WEEKLY SCHEDULE           
==========================================

  [ MONDAY ]
    [    ] Monday | Mathematics | 2 hr(s) | Priority: High

  [ TUESDAY ]
    [    ] Tuesday | Mathematics | 2 hr(s) | Priority: High
    [    ] Tuesday | Physics | 1 hr(s) | Priority: Medium
...
```

**After marking tasks complete:**
```
==========================================
           PROGRESS REPORT               
==========================================
  Total Tasks   : 8
  Completed     : 5
  Remaining     : 3
  Completion    : 62%

  Halfway there! Keep going!
==========================================
```

---

## 💾 Data Persistence

Your schedule is automatically saved to `study_data.txt` in the same directory when you exit. It is reloaded the next time you run the program — so your progress is never lost.

---

## 🧠 Java Concepts Used

| Concept | Where Used |
|---|---|
| OOP (Classes & Objects) | `Task`, `StudyPlanner`, `UserInput`, `FileManager` |
| ArrayList (Collections) | Storing and sorting tasks in `StudyPlanner` |
| File Handling | `FileManager` reads/writes `study_data.txt` |
| Exception Handling | Input validation and file I/O errors |
| Sorting (Comparator) | Priority-based schedule sorting |

---

## 👤 Author

**Aditya Roshan Singh**  
Course: Programming in Java  
Institution: VIT  
7b8863a (Initial commit: adding project files)
Year: 2026
