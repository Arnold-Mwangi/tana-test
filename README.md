# Take Home Assignment

A collection of algorithmic solutions for coding assessment, structured as a professional Java project with Maven build system.

## 📁 Project Structure

```
take-home-assignment/
├── src/
│   ├── main/java/com/assignment/
│   │   ├── AssignmentRunner.java          # Main runner for all solutions
│   │   ├── solutions/                     # Individual solution classes
│   │   │   ├── GetLongestString.java     # Solution 1: String validation
│   │   │   ├── [Solution2].java          # TODO: Add solution 2
│   │   │   ├── [Solution3].java          # TODO: Add solution 3
│   │   │   ├── [Solution4].java          # TODO: Add solution 4
│   │   │   └── [Solution5].java          # TODO: Add solution 5
│   │   └── utils/
│   │       └── TestDataGenerator.java    # Utility for generating test data
│   └── test/java/com/assignment/solutions/
│       ├── GetLongestStringTest.java     # Unit tests for solution 1
│       └── [Additional test files...]    # Tests for other solutions
├── pom.xml                               # Maven build configuration
├── .gitignore                           # Git ignore rules
└── README.md                            # This file
```

## 🚀 Solutions Implemented

### 1. GetLongestString
**Problem**: Find the longest valid string from an array based on character constraints.

**Features**:
- Validates strings contain only allowed characters
- Ensures no consecutive duplicate characters
- Handles null inputs gracefully
- Optimizes by skipping shorter strings

**Usage**:
```java
String characters = "abc";
String[] strings = {"ab", "abc", "abcd", "aab", "bca"};
String result = GetLongestString.getLongestString(characters, strings);
// Returns "abc"
```

### 2-5. Additional Solutions
*TODO: Add descriptions as solutions are implemented*

## 🛠️ Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Building the Project
```bash
# Compile all sources
mvn compile

# Run all tests
mvn test

# Create executable JAR
mvn package
```

### Running Solutions

#### Option 1: Run the main runner (recommended)
```bash
# Run all solutions with demonstrations
mvn exec:java -Dexec.mainClass="com.assignment.AssignmentRunner"

# Or after building JAR
java -jar target/take-home-assignment-1.0.0.jar
```

#### Option 2: Run individual solutions
```bash
# Compile and run specific solution
mvn compile exec:java -Dexec.mainClass="com.assignment.solutions.GetLongestString"
```

#### Option 3: Run tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=GetLongestStringTest
```

## 📊 Testing Strategy

Each solution includes:
- **Unit tests** with JUnit 5
- **Edge case testing** (null inputs, empty arrays, etc.)
- **Performance considerations** for large inputs
- **Test data generation** utilities for consistent testing

### Running Tests
```bash
# Run all tests with detailed output
mvn test

# Run tests for specific solution
mvn test -Dtest=GetLongestStringTest

# Generate test coverage report (if configured)
mvn jacoco:report
```

## 🏗️ Development Guidelines

### Adding New Solutions

1. **Create the solution class**:
   ```bash
   # Create in src/main/java/com/assignment/solutions/
   touch src/main/java/com/assignment/solutions/YourSolution.java
   ```

2. **Follow the template**:
   ```java
   package com.assignment.solutions;
   
   public class YourSolution {
       public static ReturnType solutionMethod(InputType input) {
           // Implementation here
           return result;
       }
   }
   ```

3. **Add corresponding tests**:
   ```bash
   touch src/test/java/com/assignment/solutions/YourSolutionTest.java
   ```

4. **Update AssignmentRunner.java** to include your solution demonstration

5. **Update this README** with solution description

### Code Quality Standards
- **Documentation**: All public methods must have JavaDoc
- **Testing**: Minimum 80% test coverage expected
- **Null Safety**: Handle null inputs gracefully
- **Performance**: Consider time/space complexity
- **Style**: Follow standard Java conventions

## 🔧 Build Configuration

- **Java Version**: 11
- **Maven Version**: 3.11.0
- **Testing Framework**: JUnit 5.9.2
- **Main Class**: `com.assignment.AssignmentRunner`

## 📈 Performance Considerations

Each solution is designed with performance in mind:
- Time complexity analysis included in JavaDoc
- Space-efficient implementations
- Early termination optimizations where applicable
- Scalable for large input sizes

## 🤝 Contributing

When adding new solutions:
1. Follow the established package structure
2. Include comprehensive tests
3. Add performance analysis
4. Update documentation
5. Test the AssignmentRunner integration

## 📝 Assignment Checklist

- [x] **Solution 1**: GetLongestString ✅
- [ ] **Solution 2**: [TODO]
- [ ] **Solution 3**: [TODO]
- [ ] **Solution 4**: [TODO]
- [ ] **Solution 5**: [TODO]
- [x] **Project Structure**: Professional Maven setup ✅
- [x] **Testing Framework**: JUnit 5 configured ✅
- [x] **Documentation**: README and JavaDoc ✅
- [x] **Build System**: Maven with proper configuration ✅
