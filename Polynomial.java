import LinkedList.Node;

/**
 * Polynomial.java
 * 
 * @author PARTNER_1_NAME
 * @author PARNTER_2_NAME CIS 22C, Lab 2
 */
public class Polynomial {
	private LinkedList<Term> poly;

	/**
	 * Default Polynomial constructor whose purpose is to initialize poly to an
	 * empty LinkedList
	 */
	public Polynomial() {
		poly = new LinkedList<Term>();
	}

	/**
	 * Polynomial copy constructor whose purpose is to initialize poly and then copy
	 * the data from p into this Polynomial
	 * 
	 * @param p a Polynomial to copy Hint: Make sure that you create a deep copy not
	 *          a shallow copy Also: don't forget to check the edge case
	 */
	public Polynomial(Polynomial p) {
		p.poly.positionIterator();
		if (p.poly.offEnd()) {
			return;
		}
		if (p.poly.getLength() == 0) {
			poly = new LinkedList<Term>();
		} else {
			poly = new LinkedList<Term>();
			this.poly.positionIterator();
			poly.addFirst(p.poly.getFirst()); 
			while (!p.poly.offEnd()) {
				poly.addLast(p.poly.getIterator());
				p.poly.advanceIterator();
			}
		}
	}

	/**
	 * Adds a new Term to the end of the Polynomial
	 * 
	 * @param exponent    the exponent of the Term
	 * @param coefficient the coefficient of the Term
	 */
	public void addTerm(int exponent, double coefficient) {
		Term N = new Term(exponent,coefficient); 
		poly.addLast(N); 
	}

	/**
	 * Assigns a new coefficient to an existing Term
	 * 
	 * @param exponent       the exponent of the Term (i.e. its position within the
	 *                       Polynomial)
	 * @param newCoefficient the coefficient to assign
	 * @precondition 0 <= exponent <= poly.first.exponent
	 * @throws IllegalArgumentException when exponent larger than the exponent of
	 *                                  the leading order Term or less than 0
	 */
	public void updateTerm(int exponent, double newCoefficient) throws IllegalArgumentException {
		poly.positionIterator();
		if(exponent < 0 || exponent > poly.getFirst().getExponent()) {
			throw new IllegalArgumentException("updateTerm(): The exponent is larger than the exponent of the leading order Term or less than 0" );
		}
		while (!poly.offEnd()) {
			if(exponent == poly.getIterator().getExponent() ) {
				poly.getIterator().setCoefficient(newCoefficient);
			}
			poly.advanceIterator();
		}
	}

	/**
	 * A helper method for evaluate. Evaluates a single term in the Polynomial by
	 * plugging in the value For example: If the term is 3.0x2 and the value is 5.0
	 * This function will return 75.0 since 3.0*5.0*5.0=75.0
	 * 
	 * @param t     a Term to evaluate
	 * @param value the value to plug in for x
	 * @return the result of evaluating the Term
	 */
	private double evaluateTerm(final Term t, double value) {
		double result; 
		result = t.getCoefficient() * Math.pow(value, t.getExponent());
		return result;
	}

	/**
	 * Evaluates the Polynomial by plugging in the given value at all terms
	 * 
	 * @param value the value to plug into the equation
	 * @return the result of evaluating the polynomial by plugging in value for x
	 */

	public double evaluate(double value) {
		poly.positionIterator();
		double result = 0.0;
		while(!poly.offEnd()) {
			result += evaluateTerm(poly.getIterator(), value);
			poly.advanceIterator();
		}
		return result;
	}

	/**
	 * Adds two Terms - helper method for add
	 * 
	 * @param t1 the first Term to add
	 * @param t2 the second Term to add
	 * @return the resulting Term from adding t1 and t2
	 * @precondition t1 and t2 cannot be null
	 * @precondition t1.exponent == t2.exponent
	 * @throws NullPointerException     when either t1 or t2 is null
	 * @throws IllegalArgumentException when the exponents for t1 and t2 are not the
	 *                                  same
	 */
	private Term addTerms(Term t1, Term t2) throws NullPointerException, IllegalArgumentException {
        poly.positionIterator();
        if(t1 == null || t1 == null) {
          throw new NullPointerException("addTerms(): There are no terms. Terms are empty");
        }
        else if(t1.getExponent() != t2.getExponent()) {
          throw new IllegalArgumentException("addTerms(): The exponents should be the same  in order to add the terms");
        }
        else {
        int result1 = t1.getExponent();
        double result2 = t1.getCoefficient() + t2.getCoefficient();
        addTerm(result1, result2);
        
        return poly.getLast();
        }
        
      }

	/**
	 * Adds p to this Polynomial
	 * 
	 * @param p another Polynomial to add to this
	 * @return a new Polynomial resulting from adding p to this Handles two
	 *         exceptions from calling addTerms by using a try-catch
	 */
	public Polynomial add(final Polynomial p) throws NullPointerException, IllegalArgumentException {
        this.poly.positionIterator();
        p.poly.positionIterator();
        Polynomial result = new Polynomial();
        result.poly.positionIterator();
        try {
            while (!(this.poly.offEnd() || p.poly.offEnd())) {
                result.poly.addIterator(addTerms(this.poly.getIterator(), p.poly.getIterator()));
                p.poly.advanceIterator();
                this.poly.advanceIterator();
                result.poly.advanceIterator();
            }
        }
        catch (NullPointerException | IllegalArgumentException e) {
            System.out.print(e);
        }
        return result;
    }

	/**
	 * Subtracts p from this Polynomial
	 * 
	 * @param p another Polynomial to subtract from this
	 * @return a new Polynomial resulting from subtracting p from this
	 * @postcondition p remains unchanged
	 */
	public Polynomial subtract(final Polynomial p) {
		return null;
	}

	/**
	 * Converts this Polynomial to a String in the form <coefficient1>x<exponent1> +
	 * <coefficient2>x<exponenent2> + ... For example: 2.5x4 + 3x3 + 8.1x1 + 7.5
	 * 
	 * @return the Polynomial represented as a String
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		this.poly.positionIterator();
		while (!poly.offEnd()) {
			result.append(this.poly.getIterator().toString());
			this.poly.advanceIterator();

		}
		return result.toString() + "\n";
	}

}