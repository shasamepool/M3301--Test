package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.EvaluateurNiveau;
import code.ExceptionHorsBorne;
import code.ExceptionNoteNonEntiere;

public class TestsEvaluateur {
	
	
	@Test
	@DisplayName("Test exception si la note de cours n'est pas entière")
	public void testExceptionCoursNonEntiere() {
		assertThrows( ExceptionNoteNonEntiere.class ,
			() -> { EvaluateurNiveau.evaluerNiveau("xxx", "50");});
	}
	
	@Test
	@DisplayName("Test exception si la note d'examen n'est pas entière")
	public void testExceptionExamenNonEntiere() {
		assertThrows( ExceptionNoteNonEntiere.class ,
			() -> { EvaluateurNiveau.evaluerNiveau("20", "50.6");});
	}

	@Test
	@DisplayName("Test exception si la note de cours n'est pas dans [0..25]")
	public void testExceptionCoursHorsBornes() {
		assertThrows( ExceptionHorsBorne.class ,
			() -> { EvaluateurNiveau.evaluerNiveau("26", "50");});
	}
	
	@Test
	@DisplayName("Test exception si la note d'examen n'est pas dans [0..75]")
	public void testExceptionExamenHorsBornes() {
		assertThrows( ExceptionHorsBorne.class ,
			() -> { EvaluateurNiveau.evaluerNiveau("20", "76");});
	}
	
	@ParameterizedTest( name="Test que si cours={0} et examen = {1} "
			+ "alors le niveau est {2}")
	@CsvSource( { "0,0,D" , "25,4,D" , "15,15,C" , "0,49,C" , "20,30,B" ,
		          "20,49,B" , "20,50,A" , "25,75,A" })
	public void testLimites( String cours, String examen, String niveauAttendu ) throws ExceptionNoteNonEntiere, ExceptionHorsBorne{
		String niveauObtenu = EvaluateurNiveau.evaluerNiveau(cours, examen);
		assertEquals( niveauAttendu , niveauObtenu );
	}
	
	
	
	
	
	
	
	

}
