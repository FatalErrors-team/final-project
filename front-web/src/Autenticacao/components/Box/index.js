import { useState } from 'react';

import Login from '../Login';
import Cadastro from '../Cadastro';

import "./style.css";

function LoginBox() {

  const [oculto, setOculto] = useState(true);
  const [metodo, setMetodo] = useState("Ainda não tem uma conta?");

  function alterarMetodo() {
    setOculto(!oculto);
    if (metodo === "Ainda não tem uma conta?")
      setMetodo("Já possui uma conta?")
    else
      setMetodo("Ainda não tem uma conta?")

  }

  return (
    <div className="login__container">
      <div className="form__container">
        <Login oculto={oculto}/>
        <Cadastro oculto={!oculto} />
				<button onClick={alterarMetodo}>
          {metodo}
        </button>
      </div>
      <div className="login__banner">
        <h1>Sua plataforma de gerenciamento de alunos.</h1>
      </div>
    </div>
  );
}

export default LoginBox;
