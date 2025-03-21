package com.fiap.postech_reserva_restaurantes.gateways;

import java.util.List;
import com.fiap.postech_reserva_restaurantes.entities.ReservaEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.ReservaRepository;
import com.fiap.postech_reserva_restaurantes.interfaces.IReservaGateway;

public class ReservaGateway implements IReservaGateway{

	public ReservaRepository reservaRepository;
	
    public ReservaGateway(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

	public ReservaEntity criarReserva(ReservaEntity reserva) {
		// chamar mongo
		return null;
	}

	public List<ReservaEntity> procurarReservasPorUsuario(ReservaEntity reserva) {
		return null;
	}

	public List<ReservaEntity> procurarReservasPorRestaurante(ReservaEntity reserva) {
		return null;
	}

	public void atualizar(ReservaEntity reserva) {
		
	}

	public void cancelar(ReservaEntity reserva) {
		
	}
    
}
