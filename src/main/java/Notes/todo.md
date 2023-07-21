1) ~~enemy class~~
2) enemies for each floor
3) ~~Loot tables~~
4) ~~items~~
5) ~~enemy drop tables~~
6) floors
7) floor layouts/rooms
8) ~~treasure chests~~
9) random events
10) begin screen
11) ~~end screen~~
12) ~~level up system~~
13) ~~edit combat so that it doesn't allow the user to use an ability they don't have access to. prompt them for a new choice instead of just moving on to the enemy turn.~~ Solved by only displaying abilities where the levelRequirement is less or equal to player level. If they press a number that isn't displayed, it still skips their turn. 
14) ~~edit combat so that health of both parties is displayed right before the choice is made~~
15) ~~adjust the health/damage. combat feels like it takes a while.~~ 
16) add randomized descriptions of abilities/attacks to give more flavor to combat
17) add a feature on room/direction display that lists if the player has already been there
18) ~~adjust the health of the imps. player dies by the end of the second combat, guaranteed.~~
19) ~~add a game over screen/function to add to combat method~~
20) ~~add something to happen after the boss is killed to move to the next floor~~
21) ~~add gold tracker after combat~~
22) add a statGrowth variable to each class to apply to the levelUp function so they each gain stats differently
23) ~~add logic for DoT damage~~
24) ~~add abilities for Crusader and Corrupted~~
25) ~~edit the levelUp function to show how much stat was gained upon levelup~~
26) Still need to test that the aoe dmg method works
27) ~~display equipment stats when they are looked at~~
28) ~~adjust item stats~~
29) ~~adjust levelup stats. currently going from 80 max health to 166 seems like a lot unless enemies are scaled to match.~~
30) ~~levelup is also currently factoring in stats from items when leveling up, which needs to be fixed. maybe need to have 2 stats: base hp/strength/defence etc and item hp/str/def etc~~
31) ~~need to fix the reset methods. combat ends immediately after starting upon starting a new game. it also doesn't rerun character creation~~
32) ~~adjust the healing of potions. maybe small-10 med -20 large-40. 20 hp feels good early, but 5 feels useless. maybe 15/30/60~~ changed it to 15/30/60 and reduced the number that treasure room gives.
33) build the Corrupted class
34) ~~adjust enemy xpYield to scale with enemy level. will need to tweak to balance though.~~
35) randomize enemy encounters from the floor's enemy table
36) create a method to automatically generate treasure room loot based on floor level
37) lower xp gains by a lot and add random spawns
38) check enemy inventories for weapons to drop
38) floor 3, room 5 enemies aren't populating
39) add an option in combat to choose 0 to go back if the player chose attack or use item and change their mind.


~~add loot to level 1 and 2 voidImps in the VoidImpCreator~~
can delete CharacterManager since I'm handling multiple mobs in a room differently