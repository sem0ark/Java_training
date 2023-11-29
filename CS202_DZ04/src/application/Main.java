package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import util.Factory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	private int x_score = 0, o_score = 0;
	private int player = 0, moves_done = 0;
	private final String[] names = new String[] {"X", "O"};
	private final String EMPTY = "   ";
	
	private Label score, result;
	private final int cells = 5; // NB! the grid can resize!
	
	private Button[][] btn_grid;
	
	private String getScore() {
		return String.format("X %d:%d O", this.x_score, this.o_score);
	}
	
	private boolean checkWin(String type) {
		int[] row_cnt = new int[cells];
		int[] col_cnt = new int[cells];
		
		for(int i=0; i<cells; i++) {
			for(int j=0; j<cells; j++) {
				col_cnt[j] += this.btn_grid[i][j].getText().equals(type) ? 1 : 0;
				row_cnt[i] += this.btn_grid[i][j].getText().equals(type) ? 1 : 0;
			}
		}
		
		int diag1=0, diag2=0;
		
		for(int i=0; i<cells; i++) {
			diag1 += this.btn_grid[i][i].getText().equals(type) ? 1 : 0;
			diag2 += this.btn_grid[i][cells-i-1].getText().equals(type) ? 1 : 0;
			
			if(col_cnt[i] == cells) return true;
			if(row_cnt[i] == cells) return true;
		}
		
		if(diag1 == cells) return true;
		if(diag2 == cells) return true;
		
		return false;
	}
	
	private void updateState() {
		String won = "";
		moves_done++;
		if(checkWin(names[0])) {
			won = names[0];
			this.x_score++;
			this.player = 0;
		} else if(checkWin(names[1])) {
			won = names[1];
			this.o_score++;
			this.player = 0;
		} else if(moves_done == cells * cells) {
			won = "Noone";
			this.player = 0;
		} else {
			this.player ^= 1;
			result.setText("");
			return;
		}
		
		moves_done = 0;
		score.setText(getScore());
		result.setText(won + " won!");
		clearGrid();
	}
	
	private void clearGrid() {
		for(int i=0; i<cells; i++) {
			for(int j=0; j<cells; j++) {
				this.btn_grid[i][j].setText(EMPTY);
			}
		}
	}
	
	@Override
	public void start(Stage stage) {
		try {
			score = new Label(getScore());
			score.setFont(new Font(20));
			result = new Label("");
			result.setFont(new Font(20));
			
			this.btn_grid = Factory.makeButtonGrid(EMPTY, e -> {
				Button btn = (Button) e.getTarget();
				
				if(btn.getText() == EMPTY) {
					btn.setText(names[this.player]);
					updateState();
				}
			}, cells, cells, 20);
			
			BorderPane root = new BorderPane();
			root.setTop(score);
			root.setBottom(result);
			root.setCenter(Factory.makeGrid2DArr(btn_grid));
			
			BorderPane.setAlignment(root.getTop(), Pos.BOTTOM_CENTER);
			BorderPane.setAlignment(root.getBottom(), Pos.BOTTOM_CENTER);
			BorderPane.setAlignment(root.getCenter(), Pos.CENTER);
			
			Scene scene = new Scene(root, cells * 60, cells * 70 + 100);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Arkadii Semenov 5833 SI FIT");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
