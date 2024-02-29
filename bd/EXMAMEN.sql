DROP DATABASE IF EXISTS bandido;
CREATE DATABASE bandido;
USE bandido;

CREATE TABLE cliente (
	idCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellidoPaterno VARCHAR(30) NOT NULL,
    apellidoMaterno VARCHAR(30) NOT NULL,
    saldoAnterior FLOAT NOT NULL,
    montoCompras FLOAT NOT NULL,
    depositoAnterior FLOAT NOT NULL,
    saldoActual FLOAT NOT NULL,
    pagoMinimo FLOAT NOT NULL,
    pNoIntereses FLOAT NOT NULL
);
DELIMITER $$
CREATE PROCEDURE insertarCliente(/* Datos Personales */
                                    IN    var_nombre          VARCHAR(30),    --  1
                                    IN    var_apellidoPaterno VARCHAR(30),    --  2
                                    IN    var_apellidoMaterno VARCHAR(30),    --  3
                                    IN    var_saldoAnterior       FLOAT,     --  4
                                    IN    var_montoCompras FLOAT,    --  5
                                    IN    var_depositoAnterior  FLOAT, -- 6
                                    IN    var_saldoActual FLOAT, -- 7 
                                    IN    var_pagoMinimo FLOAT, -- 8
                                    in    var_pNoIntereses FLOAT -- 9
                                 )
    BEGIN
    
		SET var_saldoActual = var_saldoAnterior+var_montoCompras-var_depositoAnterior;
        
        
		SET var_pagoMinimo = var_saldoActual * 0.15;
        SET var_pNoIntereses = var_saldoActual * 0.85;
        
        INSERT INTO cliente (nombre, apellidoPaterno, apellidoMaterno, saldoAnterior,
                             montoCompras, depositoAnterior, saldoActual, pagoMinimo, pNoIntereses)
                    VALUES( var_nombre, var_apellidoPaterno, var_apellidoMaterno,
                            var_saldoAnterior, var_montoCompras,
                            var_depositoAnterior, var_saldoActual, var_pagoMinimo, var_pNoIntereses);
    END
$$
DELIMITER ;