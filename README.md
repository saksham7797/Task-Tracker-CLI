Task Tracker CLI 📝

A simple, command-line interface (CLI) tool to track and manage your daily tasks. Built entirely in Core Java without using any external libraries or frameworks (no Jackson/Gson), focusing on raw file handling and string manipulation logic.

This project is part of the roadmap.sh backend developer roadmap.

🚀 Features
Add Tasks: Create new tasks with a description.

List Tasks: View all tasks with their ID, description, and status.

Update Tasks: Modify the description of existing tasks.

Delete Tasks: Remove tasks permanently by their ID.

Data Persistence: Automatically saves all data to a local tasks.json file.

Zero Dependencies: No external JSON libraries used; implemented a custom parser to read/write JSON data.

🛠️ Prerequisites
Java Development Kit (JDK): Version 11 or higher.

📦 How to Run
Clone the repository (or download the files):

Bash

git clone https://github.com/saksham7797/Task-Tracker-CLI-.git
cd task-tracker
Compile the Java file:

Bash

javac TaskTracker.java
Run the application: Use the java TaskTracker command followed by the operation you want to perform.

💻 Usage Commands
Here are the commands to use the application:

1. Add a new task
Bash

java TaskTracker add "Buy groceries for the week"
# Output: Task added successfully (ID: 1)

2. List all tasks
Bash

java TaskTracker list
# Output:
# [1] Buy groceries for the week - Status: todo
# [2] Finish Java project - Status: in-progress

3. Update a task
Provide the Task ID and the New Description.

Bash

java TaskTracker update 1 "Buy groceries and snacks"
# Output: Task updated successfully.

4. Delete a task
Provide the Task ID to remove.

Bash

java TaskTracker delete 1
# Output: Task deleted successfully.

🧠 Technical Highlights (How it works)
Since external libraries like Jackson were not allowed, I implemented a custom logic to handle JSON data:

Data Storage: Tasks are stored in a tasks.json file in the current directory.

Custom Parser:

Saving: Uses StringBuilder to manually construct valid JSON strings from Java objects.

Loading: Reads the file as a raw String, removes brackets, and uses regex-based splitting (anchoring on }, { patterns) to separate objects. Then, it parses individual fields (id, description, etc.) using custom string extraction logic.

File Handling: Uses java.nio.file.Files for efficient reading and writing.

📂 Project Structure
task-tracker/
├── TaskTracker.java    # Main entry point and logic
├── Task.java           # Model class for Task object
├── tasks.json          # Auto-generated file storing your data
└── README.md           # Documentation
🤝 Contributing
Feel free to fork this repository and submit pull requests to add features like:

Marking tasks as in-progress or done.

Listing tasks by status (e.g., list done).
