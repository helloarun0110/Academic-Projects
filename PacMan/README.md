
![logo](https://github.com/user-attachments/assets/154a7b23-fff3-4749-91f7-b59ac8112de0)


##   Class Diagram of the PacMan Game Project






```mermaid
classDiagram
    class App {
        +main(args: String[]) void
    }
    class GameFrame {
        -tileSize: int = 32
        -rows: int = 21
        -cols: int = 19
        +GameFrame()
        +start() void
    }
    class GamePanel {
        -board: GameBoard
        -timer: Timer
        +GamePanel(rows: int, cols: int, tileSize: int)
        +actionPerformed(e: ActionEvent) void
        +paintComponent(g: Graphics) void
        +keyPressed(e: KeyEvent) void
    }
    class GameBoard {
        -rows: int
        -cols: int
        -tileSize: int
        -walls: Set~GameEntity~
        -foods: Set~GameEntity~
        -ghosts: Set~Ghost~
        -pacman: PacMan
        -score: int
        -lives: int
        -gameOver: boolean
        -scareMode: boolean
        -bonusFood: GameEntity
        +GameBoard(rows: int, cols: int, tileSize: int)
        +loadMap() void
        +update() void
        +draw(g: Graphics) void
        +handleKeyPress(e: KeyEvent) void
        +activateScareMode() void
    }
    class GameEntity {
        #x: int
        #y: int
        #size: int
        #oldX: int
        #oldY: int
        #image: Image
        +GameEntity(x: int, y: int, size: int)
        +setImage(path: String) void
        +draw(g: Graphics) void
        +collidesWith(other: GameEntity) boolean
    }
    class PacMan {
        -dx: int
        -dy: int
        -pacmanImages: Image[]
        +PacMan(x: int, y: int, size: int)
        +setDirection(dir: char) void
        +move() void
        +undo() void
        +draw(g: Graphics) void
    }
    class Ghost {
        -dx: int
        -dy: int
        -ghostColor: GhostColor
        -isScared: boolean
        +Ghost(x: int, y: int, size: int, color: GhostColor)
        +move(walls: Set~GameEntity~) void
        +setScared(scared: boolean) void
        +draw(g: Graphics) void
        +reset() void
    }

    App --> GameFrame : creates
    GameFrame --> GamePanel : contains
    GamePanel --> GameBoard : has-a
    GamePanel --> Timer : triggers
    GameBoard --> GameEntity : contains *
    GameBoard --> PacMan : has-a
    GameBoard --> Ghost : contains *
    GameEntity <|-- PacMan : inherits
    GameEntity <|-- Ghost : inherits

    ```
