import { useState } from "react";
import axios from "axios";
import { ReactComponent as FormImage } from "./formImage.svg";
import Alert from '../Alert';
import "./style.css";


function FormPage() {
	const form = Object.freeze({
		nome: "",
		email: "",
		telefone: "",
		cep: "",
		logradouro: "",
		numero: "",
		curso: "",
		nota01: "",
		nota02: "",
		notaApresentacao: "",
		notaTrabalho: "",
	});

	const [formData, setFormData] = useState(form);
	const [alerts, setAlerts] = useState([]);

	function handleChange(e) {
		setFormData({
			...formData,
			[e.target.name]: e.target.value.trim(),
		});
	}

	function salvar(e) {
		e.preventDefault();

		const formatedData = {
			nome: formData.nome,
			email: formData.email,
			telefone: formData.telefone,
			endereco: {
				cep: formData.cep,
				logradouro: formData.logradouro,
				numero: formData.numero,
			},
			curso: {
				nome: formData.curso
			},
			nota01: formData.nota01,
			nota02: formData.nota02,
			notaApresentacao: formData.notaApresentacao,
			notaTrabalho: formData.notaTrabalho,
		};

		axios({
			method: "POST",
			url: "https://boiling-river-79785.herokuapp.com/alunos",
			data: JSON.stringify(formatedData),
			headers: {
				"Content-Type": "application/json",
				"Authorization": localStorage.getItem("token")
			},
		})
			.then((response) => {
				if (response.status === 201) {
					//history.push("/#lista-de-alunos");
					setAlerts([...alerts, { texto: "Salvo com sucesso!", tempo: 2000, link: "/#lista-de-alunos" }]);
					setFormData(form);
				} else {
					setAlerts([...alerts, { texto: "Houve algum erro!", tempo: 2000 }]);
				}
			})
			.catch(() => {
				setAlerts([...alerts, { texto: "Houve algum erro!", tempo: 2000 }]);
			});
	}
	return (
		<>
			{alerts.map((alert) => {
				return <Alert texto={alert.texto} tempo={alert.tempo} link={alert.link} />
			})}
			<div className="form__container">
				<FormImage className="form-image" />
				<h3 className="form-title">Informe os dados do aluno</h3>
				<form className="form-container" onSubmit={salvar}>
					<input
						className="input-item"
						type="text"
						id="nome"
						name="nome"
						onChange={handleChange}
						value={formData.nome}
						required
						placeholder="Nome"
					/>
					<input
						className="input-item"
						type="text"
						id="email"
						name="email"
						onChange={handleChange}
						value={formData.email}
						required
						placeholder="Email"
					/>
					<input
						className="input-item"
						type="text"
						id="telefone"
						name="telefone"
						onChange={handleChange}
						value={formData.telefone}
						required
						placeholder="Telefone (xx) xxxxx-xxxx"
					/>
					<input
						className="input-item"
						type="text"
						id="cep"
						name="cep"
						onChange={handleChange}
						value={formData.cep}
						required
						placeholder="CEP xxxxx-xxx"
					/>
					<input
						className="input-item"
						type="text"
						id="logradouro"
						name="logradouro"
						onChange={handleChange}
						value={formData.logradouro}
						required
						placeholder="Logradouro"
					/>
					<input
						className="input-item"
						type="number"
						id="numero"
						name="numero"
						onChange={handleChange}
						value={formData.numero}
						required
						placeholder="Número"
						min="1"
					/>
					<input
						className="input-item"
						type="text"
						id="curso"
						name="curso"
						onChange={handleChange}
						value={formData.curso}
						required
						placeholder="Curso"
					/>
					<input
						className="input-item"
						type="number"
						id="nota01"
						name="nota01"
						onChange={handleChange}
						value={formData.nota01}
						required
						placeholder="Nota 01"
						min="0"
						max="10"
					/>
					<input
						className="input-item"
						type="number"
						id="nota02"
						name="nota02"
						onChange={handleChange}
						value={formData.nota02}
						required
						placeholder="Nota 02"
						min="0"
						max="10"
					/>
					<input
						className="input-item"
						type="number"
						id="notaApresentacao"
						name="notaApresentacao"
						onChange={handleChange}
						value={formData.notaApresentacao}
						required
						placeholder="Nota da Apresentação"
						min="0"
						max="10"
					/>
					<input
						className="input-item"
						type="number"
						id="notaTrabalho"
						name="notaTrabalho"
						onChange={handleChange}
						value={formData.notaTrabalho}
						required
						placeholder="Nota do Trabalho"
						min="0"
						max="10"
					/>
					<button className="salvar-btn">Salvar</button>
				</form>
			</div>
		</>
	);
}
export default FormPage;
