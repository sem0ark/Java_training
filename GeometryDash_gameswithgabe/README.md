## Description
This is a slightly modified version of the project for the [course](https://www.youtube.com/playlist?list=PLtrSb4XxIVbpSD7Gv0GLtMtKxrFmmS3K2) by GamesWithGabe.
It is an implementation of basic Geometry Dash mechanics such as:
- Level designer
- Different modes
	- Ship
	- Cube
	- UFO
- Spikes
- Blocks
- Portals
- etc.

## Implementation details
The project is written on Java language.

UI is created with Java.awt module.

All game objects are implemented with Unity based Component OOP pattern to create more flexibility to the app.

Implemented serialization (export and import) of levels.

Implemented sprite based graphics with a usage of AssetPool data structure to speed up the application.

## Controls
Editor:
- F1 - export (save) level
- F2 - import level
- F3 - Run the level

Game:
- SPACE - Jump

## Differences
- Edited some bugs with different types of spikes.
