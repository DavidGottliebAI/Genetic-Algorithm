package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class startListener implements ActionListener {

	private EvolutionViewer evolutionViewer;
	private JButton startButton;

	public startListener(EvolutionViewer evolutionViewer, JButton startButton) {
		this.evolutionViewer = evolutionViewer;
		this.startButton = startButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// takes all user inputs at runtime, right before starting the loop and passes
		// them into necesary classes
		this.evolutionViewer.setMaxGenerations();
		this.evolutionViewer.setMaxFitness();
		this.evolutionViewer.setElitismPercent();
		this.evolutionViewer.setAverageNumMutations();
		this.evolutionViewer.setSeed();
		this.evolutionViewer.setPopulationSize();
		this.evolutionViewer.setChromosomeLength();
		this.evolutionViewer.setFitnessFunction();
		this.evolutionViewer.setSelectionMethod();
		this.evolutionViewer.setExtraFitness();
		this.evolutionViewer.setExtraSelection();
		this.evolutionViewer.setTruncationPercent();
		this.evolutionViewer.setCrossover();

		// changes the name of the start button and decides what step to take
		if (!this.evolutionViewer.evolutionRunning) {
			if (this.startButton.getText().equals("Start")) {
				this.startButton.setText("Pause");
			} else if (this.startButton.getText().equals("Ready")) {
				this.startButton.setText("Start");
				return;
			} else if (this.startButton.getText().equals("Pause")) {
				this.startButton.setText("Reset");
			} else if (this.startButton.getText().equals("Continue")) {
				if (this.evolutionViewer.getNumLoops() >= this.evolutionViewer.getMaxGenerations()) {
					this.evolutionViewer.frame.setTitle(
							this.evolutionViewer.title + ": Reset or choose number of Generations greater than "
									+ (this.evolutionViewer.getNumLoops()));
					return;
				}
				this.startButton.setText("Pause");
			}
			this.evolutionViewer.setEvolutionRunning(true);
		} else {
			this.startButton.setText("Continue");
			this.evolutionViewer.setEvolutionRunning(false);
		}
		this.evolutionViewer.frame.setTitle(this.evolutionViewer.title);
	}
}
