# WWDC
Warframe Weapon DPS Calculator

## Basic DPS calculations
This will show you:
* Detailed DPS calculations (calculated instantly as you build)
* Theoretical times it takes to kill selected targets (calculated after hitting the calculate button)

![alt text](https://i.imgur.com/P8H2SPY.png)

## Customize weapons, mods, and targets
WWDC has most weapons and mods already added, but you may want to add your own (Rivens, Kitguns, higher level enemies, etc).
Accessed by clicking the respective labels at the top of the application. Click "Add or Update" when finsihed with an entry, then "Save".

![alt text](https://i.imgur.com/852oR7o.png)

## The "Maximizer"
This will test every possible combination of mods in mod slots you leave empty and present the most effective builds against your selected targets. **Very CPU intensive**.

You will need to do some preparation to reduce calculation time:
* Change the mod list over to "Maximizer Mods", a reduced list of mods without redundant and (most) bad mods.
* Further reduce the mod list by deleting mods you don't want included. (ie: fire rate on weapons you wouldn't use it on)
* Add mods that you are certain will be included in the final result. Leave a few empty spots that you want to be tested.
* It is highly suggested that you lower the TTK iterations, or even use the "Lightweight TTK". Lightweight TTK is far less accurate, but much faster.
* Click "Maximize" and wait. Depending on the number or mods in "Maximizer Mods" and the number of mods you left empty, this can take as little as 10 seconds or up to an indefinite amount of time. I don't suggest leaving more than 4 mods empty unless you are using the lightweight TTK and a very small mod list.
* The most valuable results will be presented in the text box and the complete results stored in a file called "MaximizerResults.csv" in the install folder for your personal review and archiving.

![alt text](https://i.imgur.com/kPPC8RJ.png)

## Stance Manager
Most ingame stances have not been added to the calculator. You will need to do so manually:
<details>
  <summary>Super ugly MS Paint guide!</summary>
  
![alt text](https://i.imgur.com/rS86fhq.png)

</details>
