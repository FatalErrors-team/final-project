import { useState } from "react";
import "./style.css";

function Card({ estudante }) {
  const [hidden, setHidden] = useState(false);
  const toogleDescription = () => {
    if (hidden) {
      setHidden(false);
    } else {
      setHidden(true);
    }
  }
  return (
    <>
      <div className="card-main-description">
        <h3>{ estudante.nome }</h3>
        <h3>{ estudante.curso.nome }</h3>
        <h3>{ estudante.conceito }</h3>
        <button className="card-btn" onClick={toogleDescription}>{hidden ? "MOSTRAR MENOS" : "MOSTRAR MAIS"}</button>
      </div>
      { hidden ?
        <div className="complementar-description">
          <div className="complementar-description-row">
            <h3>Nota Prova 1</h3>
            <h3>{ estudante.nota01 }</h3>
          </div>
          <div className="complementar-description-row">
            <h3>Nota Prova 2</h3>
            <h3>{ estudante.nota02 }</h3>
          </div>
          <div className="complementar-description-row">
            <h3>Nota da Apresentaçao</h3>
            <h3>{ estudante.notaApresentacao }</h3>
          </div>
          <div className="complementar-description-row">
            <h3>Nota do Trabalho</h3>
            <h3>{ estudante.notaTrabalho }</h3>
          </div>
          <div className="total-text">
            <h3>TOTAL</h3>
            <h3>{ estudante.media }</h3>
          </div>
          <button className="btn-exclude">EXCLUIR</button>
          <button className="btn-update">EDITAR</button>
        </div>
        : ''}
    </>
  )

}
export default Card;