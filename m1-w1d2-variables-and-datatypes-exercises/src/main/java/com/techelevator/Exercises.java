package com.techelevator;

public class Exercises {

	public static void main(String[] args) {
        
        /*
        INSTRUCTIONS

        The primary purposes of these exercises are to practice: 
        		
        		1. declaring variables and using assignment statements
        		2. using variables, literals, and operators within arithmetic expressions
        		3. choosing meaningful variable names
        		4. choosing appropriate data types

        One of the hardest things about programming is choosing good names. Spend time
        to find good, meaningful, and descriptive names for your variables. Clarity and
        expressiveness is more important than brevity. Err on the side of longer, more 
        descriptive names over short, cryptic ones.

        Be consistent with your choice of datatypes, especially when it comes to 
        some values like money. There are many different ways to express money. Pick one, 
        and stick with it throughout these exercises.
        
        Keep your code consistent and well formatted. When code is poorly indented, 
        or lost in a flood of blank lines, it can make code difficult to read. 
        */

        /* 
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch? 
        */
		
		// ### EXAMPLE:  
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /* 
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests? 
        */
		
		// ### EXAMPLE: 
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* 
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods? 
        */
		int racoonsInField = 3;
		int racoonsGoToHome = 2;
		int racoonsLeftInWoods = racoonsInField - racoonsGoToHome;
        /* 
        4. There are 5 flowers and 3 bees. How many less bees than flowers? 
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberLessBessThanFlowers = numberOfFlowers - numberOfBees;
        /* 
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now? 
        */
		int firstNumberOfPigeons = 1;
		int numberOfPigeonsJoined = 1;
		int pigeonsEatingCrumbsNow = firstNumberOfPigeons + numberOfPigeonsJoined;
        /* 
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now? 
        */
		int initNumberOwlsOnFence = 3;
		int numberOfOwlsJoined = 2;
		int owlsOnFenceNow = initNumberOwlsOnFence + numberOfOwlsJoined;
        /* 
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home? 
        */
		int initBeaversWorking = 2;
		int beaversWentForSwim = 1;
		int beaversStillWorking = initBeaversWorking + beaversWentForSwim;
        /* 
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all? 
        */
		int initialToucansOnLimb = 2;
		int toucansThatJoined = 1;
		int totalNumberOfToucans = initialToucansOnLimb + toucansThatJoined;
        /* 
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts? 
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int moreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts;
        /* 
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find? 
        */
		int numberOfQuarters = 1;
		int numberOfDimes = 1;
		int numberOfNickles = 2;
		float valueOfMoney = 0.25f * numberOfQuarters + 0.10f * numberOfDimes + 0.05f * numberOfNickles; 
        /* 
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all? 
        */
		int brierMuffinCount = 18;
		int macadamsMuffinCount = 20;
		int flanneryMuffinCount = 17;
		int totalMuffinCout = brierMuffinCount + macadamsMuffinCount + flanneryMuffinCount;
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
        float costOfYoyo = 0.24f;
        float costOfWhistle = 0.14f;
        float totalCostOfToys = costOfYoyo + costOfWhistle;
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
        int largeMarshmellowCount = 8;
        int miniMarshmellowCount = 10;
        int totalMarshmellowCount = largeMarshmellowCount + miniMarshmellowCount;
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
        int inchesSnowAtHilts = 29;
        int inchesSnowAtBrecknock = 17;
        int howMuchMoreSnowAtHilts = inchesSnowAtHilts - inchesSnowAtBrecknock;
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
        int initialHiltMoney = 10;
        int toyTruckCost = 3;
        int pencilCaseCost = 2;
        int hiltMoneyLeft = initialHiltMoney - toyTruckCost - pencilCaseCost;
        
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
        int initialMarbleCount = 16;
        int marbleLostCount = 7;
        int currentMarbleCount = initialMarbleCount - marbleLostCount;
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int initialSeashellCount = 19;
        int targetSeashellCount = 25;
        int numberOfSeashellsToFind = targetSeashellCount - initialSeashellCount;
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
        int totalBalloonCount = 17;
        int redBalloonCount = 8;
        int greenBalloonCount = totalBalloonCount - redBalloonCount;
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
        int initialBookOnShelfCount = 38;
        int booksPlacedOnShelfCount = 10;
        int currentBookOnShelfCount = initialBookOnShelfCount + booksPlacedOnShelfCount;
        
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
        int singleBeeLegCount = 6;
        int beeCount = 8;
        int beeLegCount = singleBeeLegCount * beeCount;
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
        float iceCreamConeCost = 0.99f;
        int iceCreamConeCount = 2;
        float totaliceCreamConeCost = iceCreamConeCost * iceCreamConeCount;
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int requiredRockCount = 125;
        int currentRockCount = 64;
        int neededRockCount = requiredRockCount - currentRockCount;
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
        int initialHiltMarbleCount = 38;
        int lostHiltMarbelCount = 15;
        int currentHiltMarbleCount = initialHiltMarbleCount - lostHiltMarbelCount;
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        int milesToConcert = 78;
        int milesBeforeStopping = 32;
        int milesLeftToDrive = milesToConcert - milesBeforeStopping;
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        int minutesShovelingOnSaturday = 90;
        int minutesShovelingOnSunday = 45;
        int totalMinutesShoveling = minutesShovelingOnSaturday + minutesShovelingOnSunday;
        /*    
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
        int hotDogCount = 6;
        float hotDogCost = 0.50f;
        float totalMoneyPaid = hotDogCount * hotDogCost;
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
        float hiltInitialMoney = 0.50f;
        float pencilCost = 0.07f;
        float pencilsCouldBeBoughtCount = hiltInitialMoney / pencilCost;
        /*    
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        int totalButterflyCount = 33;
        int orangeButterflyCount = 20;
        int redButterflyCount = totalButterflyCount - orangeButterflyCount;
        /*    
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
        float amountPaid = 1.00f;
        float candyCost = 0.54f;
        float amountChange = amountPaid - candyCost;
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
        int initialTreeCount = 13;
        int plantedTreeCount = 12;
        int finalTreeCount = initialTreeCount + plantedTreeCount;
        /*    
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
        int daysToSeeGrandma = 2;
        int hoursInOneDay = 24;
        int hoursToSeeGrandma = daysToSeeGrandma * hoursInOneDay;
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        int kimCousinCount = 4;
        int gumPiecesPerCousin = 5;
        int totalGumPiecesNeeded = kimCousinCount * gumPiecesPerCousin;
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        float danInitialMoney = 3.00f;
        float candyBarCost = 1.00f;
        float danMoneyLeft = danInitialMoney - candyBarCost;
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
        int boatInLakeCount = 5;
        int peoplePerBoat = 3;
        int totalPeopleInLake = boatInLakeCount * peoplePerBoat;
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int initialLegoCount = 380;
        int lostLegoCount = 57;
        int remainingLegoCount = initialLegoCount - lostLegoCount;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
        int initialMuffinCount = 35;
        int requiredMuffinCount = 83;
        int toBeBakedMuffinCount = requiredMuffinCount - initialMuffinCount;
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
        int willyCrayonCount = 1400;
        int lucyCrayonCount = 290;
        int willyCrayonCountSuperiority = willyCrayonCount - lucyCrayonCount;
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
        int stickersPerPageCount = 10;
        int pageCount = 22;
        int stickerCount = stickersPerPageCount * pageCount;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
        int cupcakeCount = 96;
        int childCount = 8;
        int cupcakesPerChild = cupcakeCount / childCount;
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
        int cookieCount = 47;
        int cookiePerJar = 6;
        int cookiesLeftOver = 47 % 6;
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
        int croissantCount = 59;
        int neighborCount = 8;
        int croissantsLeftOver = croissantCount % neighborCount;
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
        int oatmealCookiesPerTray = 12;
        int oatmealCookieCount = 276;
        int trayCount = oatmealCookieCount / oatmealCookiesPerTray;
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
        int pretzelCount = 480;
        int pretzelsPerServing = 12;
        int numberOfServings = pretzelCount / pretzelsPerServing;
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
        int bakedLemonCupcakeCount = 53;
        int lemonCupcakesLeftAtHomeCount = 2;
        int lemonCupcakesPerBox = 3;
        int boxesGivenCount = (bakedLemonCupcakeCount - lemonCupcakesLeftAtHomeCount) / lemonCupcakesPerBox;
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
        int initialCarrotStickCount = 74;
        int peopleCount = 12;
        int carrotSticksLeftOver = initialCarrotStickCount % peopleCount;
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
        int teddyBearCount = 98;
        int shelfTeddyBearCapacity = 7;
        int fullShelfCount = teddyBearCount / shelfTeddyBearCapacity;
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
        int pictureCount = 480;
        int picturesPerAlbum = 20;
        int requiredAlbumCount = pictureCount / picturesPerAlbum;
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
        int cardCount = 94;
        int cardsPerBox = 8;
        int fullBoxCount = cardCount / cardsPerBox;
        int leftOverCards = cardCount % cardsPerBox;
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
        int bookCount = 210;
        int shelfCount = 10;
        int booksPerShelf = bookCount / shelfCount;
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
        int cristinaCroissantCount = 17;
        int guestCount = 7;
        int croissantPerGuest = cristinaCroissantCount / guestCount;
        /*
            CHALLENGE PROBLEMS
        */
        
        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages 
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
        double billRate = 1 / 2.15; //rooms per hour
        double jillRate = 1 / 1.9; //rooms per hour
        double combinedRate = billRate + jillRate;
        double hoursToPaint5Rooms = 5 / combinedRate;
        int hoursPerDay = 24;
        double hoursToPaint623Rooms = 623 / combinedRate;
        double daysToPaint623Rooms = hoursToPaint623Rooms / hoursPerDay;
        System.out.println(daysToPaint623Rooms);
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle inital must end
        with a period.
        Example: "Hopper, Grace B." 
        */
        String myFirstName = "Kevin";
        String myLastName = "Cooler";
        String myMiddleInitial = "P";
        String myFullName = myLastName + ", " + myFirstName + ", " + myMiddleInitial +".";
        System.out.println(myFullName);
        		
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles. 
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
        float newYorkToChicagoMiles = 800f;
        float milesAlreadyTraveled = 537f;
        int percentOfTripCompleted = (int) ((milesAlreadyTraveled / newYorkToChicagoMiles)*100);
        System.out.println(percentOfTripCompleted);
        
            
	}

}
