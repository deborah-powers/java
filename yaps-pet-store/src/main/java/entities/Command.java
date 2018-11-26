package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
public class Command implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;

	// @OneToMany(mappedBy = "order")
	private List<CommandLine> commandLines;

	public Command(int id, LocalDate date, List<CommandLine> commandLines) {
		super();
		this.id = id;
		this.date = date;
		this.commandLines = commandLines;
	}

	public Command() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<CommandLine> getCommandLines() {
		return commandLines;
	}

	public void setCommandLines(List<CommandLine> commandLines) {
		this.commandLines = commandLines;
	}

}
