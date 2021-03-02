import { useState } from 'react';
import axios from 'axios';


function Login(props) {

  const form = Object.freeze({
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

  function logar(e) {
    e.preventDefault();

    axios({
      method: 'POST',
      url: 'https://boiling-river-79785.herokuapp.com/login',
      data: JSON.stringify(formData),
      headers: {
        'Content-Type': 'application/json',
      }})
      .then((response) => {
        if (response.status === 200) {
          setMessage({ status: true, text: "Você será redirecionado!" });
          localStorage.setItem("token", response.headers.authorization);
					document.location.reload();
				} else {
          setMessage({ status: false, text: "Verifique suas credenciais!" });
        }
      })
      .catch(() => {
        setMessage({ status: false, text: "Houve algum erro!" });
      });
  }



  return (
    <div className="form" style={{ display: props.oculto ? "flex" : "none" }}>
      <h2 className="form__title">Gama Alunos {props.oculto}</h2>
      <p className="form__subtitle">Realize o login para começar a usar.</p>
      <p className="form__subtitle" style={{ color: message.status ? "#27ae60" : "#e74c3c"}}>{ message.text }</p>
      <form onSubmit={logar}>
        <input type="text" name="usuario" placeholder="Usuário" required onChange={handleChange}/>
        <input type="password" name="senha" placeholder="Senha" required onChange={handleChange}/>
        <button className="form__btn-autenticacao">Entrar</button>
      </form>
    </div>
  );
}

export default Login;
