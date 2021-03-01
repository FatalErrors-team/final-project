import { useState } from 'react';
import axios from 'axios';


function Cadastro(props) {

  const form = Object.freeze({
    nomeCompleto: "",
    usuario: "",
    senha: ""
  })

  const [formData, setFormData] = useState(form);
  const [message, setMessage] = useState({ status: false, text: "" });

  function handleChange(e) {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value.trim()
    })
  }

  function cadastrar(e) {
    e.preventDefault();
    console.log(formData);

    axios({
      method: 'POST',
      url: 'http://localhost:8080/cadastro',
      data: JSON.stringify(formData),
      headers: {
        'Content-Type': 'application/json',
      }})
      .then((response) => {
        if (response.status === 201) {
          setMessage({ status: true, text: "Cadastrado com sucesso!" });
        } else {
          setMessage({ status: false, text: "Houve algum erro!" });
        }
      })
      .catch(() => {
        setMessage({ status: false, text: "Houve algum erro!" });
      });
  }

  return (
    <div className="form" style={{ display: props.oculto ? "flex" : "none" }}>
      <h2 className="form__title">Gama Alunos</h2>
      <p className="form__subtitle">Realize o cadastro para começar a usar.</p>
      <p className="form__subtitle" style={{ color: message.status ? "#27ae60" : "#e74c3c"}}>{ message.text }</p>
      <form>
        <input type="text" name="nomeCompleto" placeholder="Nome Completo" onChange={handleChange}/>
        <input type="text" name="usuario" placeholder="Usuário" onChange={handleChange}/>
        <input type="password" name="senha" placeholder="Senha" onChange={handleChange}/>
        <button className="form__btn-autenticacao" onClick={cadastrar}>Cadastrar</button>
      </form>
    </div>
  );
}

export default Cadastro;