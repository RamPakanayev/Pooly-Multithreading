# Pooly Multithreading Library

Pooly is a multithreading library in Java that assists with the management and utilization of multiple threads bundled together as a thread pool.

## Features

- **Task Interface**: Defines the tasks that can be run in the thread pool.
- **ThreadsPool Class**: Manages a pool of threads and executes tasks based on their priority.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- JUnit 5 for running the tests

### Installing

1. Clone the repository
   \```bash
   git clone https://github.com/yourusername/pooly.git
   \```
2. Compile the project
   \```bash
   javac -d . src/il/ac/hit/pooly/*.java
   \```
3. Run the main class
   \```bash
   java il.ac.hit.pooly.Main
   \```

## Running the tests

The tests can be run using JUnit. Here's an example of how to run the `ThreadsPoolTest` from the command line:

\```bash
java org.junit.runner.JUnitCore il.ac.hit.pooly.ThreadsPoolTest
\```

## Built With

- [Java](https://www.java.com/) - The programming language used
- [JUnit](https://junit.org/) - The testing framework used

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/yourusername/yourcontributingmd) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

- **Your Name** - *Initial work* - [YourUsername](https://github.com/yourusername)

See also the list of [contributors](https://github.com/yourusername/pooly/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc
