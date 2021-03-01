import { ReactComponent as FormImage } from './formImage.svg'
import './style.css'

function FormPage() {
    return (
        <>
            <div className="container">
                <FormImage className="form-image" />
                <h3 className="form-title">INFORME OS DADOS DO ALUNO</h3>
                <div className="form-container">

                    <input className="input-item" type="text" id="nome" name="nome" placeholder="Nome" />
                    <input className="input-item" type="text" id="email" name="email" placeholder="Email" />
                    <input className="input-item" type="text" id="endereco" name="endereco" placeholder="Endereço" />
                    <input className="input-item" type="text" id="curso" name="curso" placeholder="Curso" />
                    <input className="input-item" type="number" id="nota1" name="nota1" placeholder="Nota 01" />
                    <input className="input-item" type="number" id="nota2" name="nota2" placeholder="Nota 02" />
                    <input className="input-item" type="number" id="nota-apresentacao" name="nota-apresentacao" placeholder="Nota Apresentação" />
                    <button className="home-btn">SALVAR</button>
                </div>
            </div>



        </>
    )
}
export default FormPage;