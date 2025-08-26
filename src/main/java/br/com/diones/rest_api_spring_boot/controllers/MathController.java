package br.com.diones.rest_api_spring_boot.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diones.rest_api_spring_boot.exception.UnsupportedMathOperationExcetion;

@RestController
@RequestMapping("/math")
public class MathController {
  
  //http://localhost:8080/math/sum/1/2
  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  ) throws UnsupportedMathOperationExcetion {
    if (!IsNumeric(numberOne) || !IsNumeric(numberTwo)) {
      throw new UnsupportedMathOperationExcetion("Por favor insira um valor numerico!");
    }

    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  private Double convertToDouble(String strNumber) throws UnsupportedMathOperationExcetion{
    if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationExcetion("Por favor insira um valor numerico!");
    String number = strNumber.replace(",", ".");

    return Double.parseDouble(number);
  }

  private boolean IsNumeric(String strNumber) {
    if(strNumber == null || strNumber.isEmpty()) return false;
    String number = strNumber.replace(",", ".");

    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

  // http://localhost:8080/math/subtraction/1/2
  // http://localhost:8080/math/division/1/2
  
}
