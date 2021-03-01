import Home from './Home';
import NavBar from './NavBar'
import Footer from './Footer'
import { BrowserRouter, Route, Switch } from "react-router-dom";
import FormPage from './FormPage/FormPage';

function Routes() {
    return (
        <BrowserRouter>
            <NavBar />
            <Switch>
            <Route path="/cadastro-de-alunos">
                    <FormPage />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
                
            </Switch>
            <Footer />
        </BrowserRouter>
    )
}
export default Routes;