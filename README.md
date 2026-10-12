# 📦 Courier & Parcel Tracking System

A Java-based Courier & Parcel Tracking System developed using **Hibernate ORM, MySQL, and Maven**. This application helps manage parcel bookings, branch details, delivery agents, and parcel tracking history.

## 📌 Project Overview

The Courier & Parcel Tracking System is designed to simplify basic courier operations. It allows users to manage parcel information, search parcels using tracking numbers, update delivery status, and maintain tracking history.

The application uses Hibernate ORM to interact with a MySQL database and perform database operations through Java objects.

## ✨ Features

- **Parcel Management** – Add, view, search, and update parcel status.
- **Branch Management** – Save and view branch details.
- **Delivery Agent Management** – Save and view delivery agent details.
- **Tracking History** – Maintain parcel booking history and status updates.
- **Tracking Number Search** – Search parcel details using a tracking number.
- **Database Integration** – Store and retrieve records using MySQL.
- **CRUD Operations** – Create, Read, Update, and Delete database records using Hibernate.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| Hibernate ORM | Object-relational mapping |
| MySQL | Database management |
| Maven | Dependency management |
| Eclipse IDE | Development environment |

## 📂 Project Structure

```text
CourierTrackingSystem/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── courier/
│       │           ├── entity/
│       │           ├── dao/
│       │           ├── util/
│       │           └── main/
│       └── resources/
│           └── hibernate.cfg.xml
├── pom.xml
└── README.md
```

*Note: Adjust the package names and folders above to match your actual project structure.*

## ⚙️ Prerequisites

Make sure the following software is installed:

- Java JDK 17 or a compatible version configured for the project
- MySQL Server
- Eclipse IDE
- Maven (or Eclipse's integrated Maven support)

## 🗄️ Database Setup

### 1. Create the database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE courier_db;
```

### 2. Configure Hibernate

Open `src/main/resources/hibernate.cfg.xml` and configure the MySQL connection settings.

Example configuration:

```xml
<property name="hibernate.connection.driver_class">
    com.mysql.cj.jdbc.Driver
</property>

<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/courier_db
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    YOUR_MYSQL_PASSWORD
</property>

<property name="hibernate.dialect">
    org.hibernate.dialect.MySQLDialect
</property>

<property name="hibernate.hbm2ddl.auto">
    update
</property>

<property name="hibernate.show_sql">
    true
</property>
```

Replace `YOUR_MYSQL_PASSWORD` with your own local MySQL password. Never commit your actual database password to GitHub.

**Note:** The example assumes Hibernate is configured to discover your entity classes. Keep the entity registration and other settings required by your existing project.

## 📥 Installation and Setup

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the project in Eclipse

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Choose **Maven → Existing Maven Projects**.
4. Select the cloned project folder.
5. Click **Finish**.

### 3. Update Maven dependencies

Right-click the project and select:

**Maven → Update Project → OK**

Wait until Maven downloads the required dependencies.

### 4. Configure the database

- Start MySQL Server.
- Create the `courier_db` database.
- Update the database username and password in the Hibernate configuration.
- Ensure the configured MySQL port matches your local setup.

## ▶️ How to Run

1. Open the project in Eclipse.
2. Verify the MySQL connection configuration.
3. Locate the Java class containing the `main()` method.
4. Right-click the class and select **Run As → Java Application**.
5. Follow the application's menu or prompts to manage parcels, branches, delivery agents, and tracking history.

The exact main class depends on your project implementation.

## 🔍 Sample Workflow

1. Add branch details.
2. Register delivery agent details.
3. Book a parcel.
4. Save the parcel details in MySQL.
5. Search for the parcel using its tracking number.
6. Update the parcel's delivery status.
7. View the tracking history.

## 🔐 Security Notes

- Do not upload real database passwords or other credentials.
- Use placeholders in example configuration files.
- Add local credential files to `.gitignore` if your project uses them.
- Review your files before pushing them to a public repository.

## 🎯 Learning Outcomes

This project provides practical experience with:

- Hibernate ORM and entity mapping.
- Java and MySQL database integration.
- CRUD operations.
- Maven dependency management.
- Database persistence and parcel tracking workflows.

## 👨‍💻 Author

**Vijay Bharath**

GitHub: [github.com/vjbharath25](https://github.com/vjbharath25)

LinkedIn: [linkedin.com/in/vijay-bharath-47368629b](https://linkedin.com/in/vijay-bharath-47368629b)

---

⭐ If you find this project useful, feel free to explore the source code and learn from it.
