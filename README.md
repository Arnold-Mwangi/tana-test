# Tana Assessment

**Programming Language:** Java 17  
**Project Setup:** Maven with JUnit 5.9.2 for testing

## Solutions Overview

Each question has been solved in a clean, efficient, and maintainable way. I've also written unit tests to cover edge cases and ensure correctness.

### Question 1 - GetLongestString.java
**Problem:** Find longest string that contains only allowed characters and has no consecutive duplicates.

**My approach:** I first convert the allowed characters into a HashSet for O(1) lookups. Then for each candidate string, I validate it character by character:

- If any character is not in the set → reject it.
- If it has two consecutive duplicates → reject it.
- Among valid strings, I track the longest one. 

This approach is simple and efficient (O(n * m) where m is string length).

### Question 2 - FirstUniqueProduct.java  
**Problem:** Find the first product that appears exactly once in the array.

**My approach:** I use a LinkedHashMap which keeps insertion order while storing counts.

- First pass: count occurrences.
- Second pass: return the first key with count = 1.

This ensures O(n) time with natural handling of order.

### Question 3 - ClosestMinimums.java
**Problem:** Find distance between the two closest minimum values in an array.

**My approach:** Two-pass algorithm:

- First pass: find the smallest number.
- Second pass: iterate again to track indices of that minimum and compute smallest gap between two occurrences.
- If the minimum occurs only once, return -1.

This runs in linear time O(n) with O(1) extra space.

### Question 4 - CommonWords.java
**Problem:** Return top 3 most common words from a sentence, sorted alphabetically when tied.

**My approach:** 

- Normalize input to lowercase and split on regex `[^a-z0-9]+`.
- Count occurrences using a HashMap.
- Sort entries by frequency (desc) then alphabetically.
- Handle ties by keeping all words with the same frequency and trimming to top 3 in alphabetical order.

### Question 5 - RotateList.java
**Problem:** Rotate a LinkedList n positions to the right.

**My approach:** Instead of reimplementing rotation logic, I used Java's Collections.rotate() which is optimized for this.

- First normalize n using modulo (n % size) so very large rotations wrap correctly.
- Negative values are adjusted to equivalent right rotations.

This makes the solution short, clean, and correct.

## How to Run

### Quick Demo (See all solutions working)
```bash
# Compile everything
javac -cp target/classes -d target/classes src/main/java/com/assignment/**/*.java

# Run the demo - shows examples of each solution
java -cp target/classes com.assignment.AssignmentRunner
```

### Run All Tests (Comprehensive validation)
```bash
# This runs all my test cases - hundreds of them covering edge cases
mvn test
```

### Manual compilation (if you don't have Maven)
```bash
# Compile main code
javac -d target/classes src/main/java/com/assignment/**/*.java

# Run the demo
java -cp target/classes com.assignment.AssignmentRunner
```

## Test Coverage

I've written comprehensive tests for each solution covering:

- Basic functionality with the examples given
- Edge cases (null inputs, empty arrays, boundary conditions)
- Performance scenarios with large inputs
- Error handling

Each solution has its own test file in `src/test/java/com/assignment/solutions/` with multiple test methods. You can run individual test suites like:

```bash
mvn test -Dtest=GetLongestStringTest
mvn test -Dtest=FirstUniqueProductTest
```

You can also extend testing by writing your own JUnit test classes, for example:
```java
@Test
public void testRotateListWithEmptyList() {
    LinkedList<String> list = new LinkedList<>();
    LinkedList<String> result = RotateList.rotateRight(list, 5);
    assertTrue(result.isEmpty());
}
```


## Project Structure

This is a proper Maven project with:

- `src/main/java` - All solution implementations
- `src/test/java` - Comprehensive unit tests  
- `AssignmentRunner.java` - Demo runner showing all solutions
- `pom.xml` - Maven configuration with JUnit 5

## Notes

- Code prioritizes clarity and maintainability over clever tricks.
- Each solution is efficient in both time and space.
- I used built-in Java utilities (HashMap, LinkedHashMap, Collections.rotate) where appropriate.
- Tests are as important as implementations – they show confidence that edge cases are covered.