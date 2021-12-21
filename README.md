# InterviewTest

This is a simple java project with several issues to help to interview tech candidates.
The business logic is fine. This project has only technical issues.

You'll have 1 hour to compile and do all refactoring that you can to improve the code legibility and maintenance.

**Caution**: To your delivery the follow itens are mandatory:
- The code must compile
- The tests must pass after your changes
- You have to submit the changes to interviewers before the test timeouts. Watch your time!

---

## How to use

> Prerequisites: JVM 11, Maven

1. Clone this repo
2. Run git checkout to `1h` or `30m`
3. Run the tests using terminal `mvn test` or your IDE
4. Fix the issues
5. Do the refactoring of the code (use your best efforts in this phase and speek while you are refactoring, to allow the interviewer knows what do you thinking)
6. Run the tests again
7. Commit all changes
8. Create a git patch using the below commands:

       git format-patch 30m -o patch

   or

       git format-patch 1h -o patch

   This will generate the patch folder in your project root.

9. Send the patch folder zipped with your name and the test type (30m | 1h) to the interviews.

   Examples:
    - ze-maria-30m.zip
    - maria-jose-1h.zip

10. Have fun

---


## To interviewers only

To apply the patch in your project, follow the rules:

1. Unzip the candidate patch file
2. Go to interviewTest root folder and run the follow commands:

   Notice: the branch to checkout is the one informed in the zip file name (30m or 1h)

       git pull --all
       git checkout < 30m | 1h >
       git am path/to/candidate/patches/*.patch

       git log --pretty=oneline --graph
   

