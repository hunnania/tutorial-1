Eshop Link: https://eshop-hunnania.koyeb.app/
<details>
    <summary>Module #1</summary>

# Module 1
## Reflection 1
I have applied most of the clean code principles that I've learned this week to my code in this tutorial.
Firstly, I have written my variables and arguments to be meaningful and self-descriptive. Secondly,
I have written my functions to be small, using descriptive names, and applied command query separation.
Then, I have written my codes with the right layout and formatting.

I have found a mistake in my `ProductList.html` where I wrote comments instead of explaining it through my code.
I think I can fix it by stating a class for the delete and edit button.

## Reflection 2
1. I feel like I have to practice more on writing unit tests because I'm still a little bit confused when
   writing it. The number of tests we should write depends on how many features we have and how complex it is.
   Having a 100% code coverage doesn't mean our code is guaranteed having no bugs and errors. Code coverage
   only measures the percentage of code that is executed by our tests. Our tests can also have bugs or errors
   and does not guarantee that all possible execution paths or scenarios have been tested.

</details>
<details>
    <summary>Module #2</summary>

# Module 2
1. I have added more unit tests for the product service, product controller, and homepage controller. The
strategies I used are to look at the code coverage report from jacoco. Then, I looked at which part is still
low for the code coverage percentage. After that, I clicked at the Java files one by one from the report and
make the unit tests for the methods that haven't been tested yet. After making the unit tests, I took a look at
the newest report and try to improve my code coverage if I still can.
2. Yes. To implement CI, I have used a few tools such as JUnit, Scorecard, and SonarCloud. These tools will help
me monitor, integrate, and validate code changes automatically. This ensures that changes are regularly and 
smoothly integrated into the main codebase, reducing integration issues. To implement CD, I have deployed my app to 
Koyeb with Dockerfile which is fast and efficient. This ensures that validated code changes are deployed to production 
or staging environments automatically, reducing manual intervention and deployment errors. Both workflows are automated, 
triggered by code changes in the repository, specifically, `master` branch. This automation speeds up the development 
cycle, improves code quality, and ensures that the latest changes are always available in the deployment environment.
</details>