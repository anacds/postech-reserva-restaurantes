const dbName = "reserva-restaurantes";
const db = db.getSiblingDB(dbName);

db.createCollection("restaurantes");
db.createCollection("mesas");
db.createCollection("usuarios");
db.createCollection("reservas");
db.createCollection("avaliacoes");

db.restaurantes.insertOne({
    _id: ObjectId("64f7c4d19b7e4c2a5e4d8769"),
    nome: "Bistrô",
    cnpj: "74.465.167/0001-64",
    endereco: {
        logradouro: "Rua das Flores, 123",
        cidade: "São Paulo",
        estado: "SP",
        bairro: "Campo Belo",
        cep: "76829-583",
        numero: 123,
        complemento: "Apto 13"
    },
    tipoCozinha: ["Francesa", "Gourmet"],
    horariosFuncionamento: [
        { diaSemana: "Terça-feira", horarioAbertura: "12:00", horarioFechamento: "22:00" },
        { diaSemana: "Quarta-feira", horarioAbertura: "12:00", horarioFechamento: "22:00" },
        { diaSemana: "Quinta-feira", horarioAbertura: "12:00", horarioFechamento: "22:00" },
        { diaSemana: "Sexta-feira", horarioAbertura: "12:00", horarioFechamento: "22:00" },
        { diaSemana: "Sábado", horarioAbertura: "18:00", horarioFechamento: "00:00" },
        { diaSemana: "Domingo", horarioAbertura: "18:00", horarioFechamento: "00:00" }
    ],
    capacidade: 50
});

 db.restaurantes.insertOne({
	 _id: "2",
	 nome: "Restaurante Exemplo", 
	 cnpj:"64.113.678/0001-63",
	 endereco: 
		  {rua: "Rua Portugal", 
		  cidade: "São Paulo", 
		  estado: "SP", 
		  bairro: "Rincão",
		  cep: "93348-520", 
		  numero: 15,
		  complemento: "152"}, 
	tipoCozinha: ["Francesa"], 
	horariosFuncionamento:
	 [{diaSemana:"Sábado", horarioAbertura: "12:00", horarioFechamento: "22:00"}]})

db.mesas.insertOne({
    _id: ObjectId("64f7c16d9b7e4c2a5e4d8765"),
    restaurante_id: ObjectId("64f7c4d19b7e4c2a5e4d8769"),
    numero: 1,
    capacidade: 4,
    localizacao: "Salão principal",
    reservas: [
        {
            reserva_id: ObjectId("64f7c2ae9b7e4c2a5e4d8767"),
            dataHoraInicio: "2025-03-05T18:00:00Z",
            dataHoraFim: "2025-03-05T20:00:00Z",
            status: "CONFIRMADA"
        }
    ]
});

db.usuarios.insertOne({
    _id: ObjectId("64f7c3cf9b7e4c2a5e4d8768"),
    nome: "João Silva",
    email: "joao.silva@gmail.com",
    reservas: [ObjectId("64f7c2ae9b7e4c2a5e4d8767")]
});


db.reservas.insertOne({
    _id: ObjectId("64f7c2ae9b7e4c2a5e4d8767"),
    usuario_id: ObjectId("64f7c3cf9b7e4c2a5e4d8768"),
    restaurante_id: ObjectId("64f7c4d19b7e4c2a5e4d8769"),
    mesa_id: ObjectId("64f7c16d9b7e4c2a5e4d8765"),
    dataHoraInicio: "2025-03-05T18:00:00Z",
    dataHoraFim: "2025-03-05T20:00:00Z",
    status: "CONFIRMADA",
    quantidadePessoas: 4,
    observacao: "Comemoração de aniversário."
});


db.avaliacoes.insertOne({
    _id: ObjectId("64f7c9d19b7e4c2a5e4d8790"),
    restaurante_id: ObjectId("64f7c4d19b7e4c2a5e4d8769"),
    usuario_id: ObjectId("64f7c3cf9b7e4c2a5e4d8768"),
    nota: 4.5,
    comentario: "Ótima comida e ambiente agradável.",
    dataAvaliacao: "2025-03-06T15:30:00Z"
});