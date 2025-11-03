# 🧩 Jenkins Exercises Shared Library

This repository contains a **Jenkins Shared Library** used by the [jenkins-exercises](https://github.com/danimatuko/jenkins-exercises) project.  
It is part of the **DevOps Bootcamp** and centralizes all build, test, and deployment logic for Node.js applications.  


## 📂 Project Structure

```

jenkins-exercises-shared-lib/
│
├── vars/
│   ├── installDependencies.groovy      # Installs npm dependencies
│   ├── runTests.groovy                 # Runs unit tests
│   ├── incrementVersion.groovy         # Bumps app version
│   ├── buildApp.groovy                 # Builds Docker image
│   ├── commitVersionChange.groovy      # Commits version bump to GitHub
│   ├── deployApp.groovy                # Deploys Docker container
│   └── logMessage.groovy               # Simple logging utility
│
└── README.md

````

Each file in `vars/` defines a **global pipeline step** available to any Jenkinsfile that loads this library.  

---

## ⚙️ Jenkins Configuration

1. Go to **Manage Jenkins → Configure System → Global Pipeline Libraries**  
   - **Name:** `jenkins-exercises-shared-lib`  
   - **Default version:** `main`  
   - **Retrieval method:** Modern SCM  
   - **Source Code Management:** Git  
   - **Repository URL:** `https://github.com/danimatuko/jenkins-exercises-shared-lib.git`

2. Reference it in your Jenkinsfile:

   ```groovy
   @Library('jenkins-exercises-shared-lib')_
   ```


## 🧠 Available Steps

| Step                    | Description                                                            |
| ----------------------- | ---------------------------------------------------------------------- |
| `installDependencies()` | Installs npm dependencies in the `app` directory.                      |
| `runTests()`            | Executes `npm test` in the `app` directory.                            |
| `incrementVersion()`    | Increments patch version in `package.json` and sets `env.APP_VERSION`. |
| `buildApp()`            | Builds Docker images tagged with `${APP_VERSION}` and `latest`.        |
| `commitVersionChange()` | Pushes version changes back to GitHub using Jenkins credentials.       |
| `deployApp()`           | Stops old container and redeploys the app on port 3000.                |
| `logMessage("text")`    | Simple utility for custom logging.                                     |



## 🧾 Notes

* Requires **Docker** and **Node.js** on the Jenkins agent.
* Uses credentials with ID `github-credentials` for Git operations.
* Modify ports, container name, or repository URL as needed.  
