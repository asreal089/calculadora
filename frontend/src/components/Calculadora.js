import React, { Component } from 'react';
const axios = require('axios');

class Calculadora extends Component {
    constructor(props) {
        super(props);
        this.state = {
            operacao: "soma",
            valorA: 0,
            valorB: 0,

		};
    }

    myChangeHandler = (event) => {
		let nam = event.target.name;
		let val = event.target.value;
		this.setState({ [nam]: val });
    };
    
    mySubmitHandler = async (event) => {
        event.preventDefault();
        try {
            
            const res =await axios.put('http://localhost:8080/api/'+this.state.operacao, {
                "a": this.state.valorA,
                "b": this.state.valorB
            },{
                "headers": {
                "content-type": "application/json",
                },
            });
            alert("O resultado da sua conta é :"+ res.data.result);
            
        } catch (error) {
            alert('operação inválida');    
        }
	};

    render() {
        return (
            <div className="container">
                <form onSubmit={this.mySubmitHandler}>

                    <div className="defaultForm">
                        <input
    						name="valorA"
    						type="number"
    						placeholder="A"
                            value={this.state.valorA}
                            onChange={this.myChangeHandler}
    					/>
                         <input
    						name="valorB"
    						type="number"
    						placeholder="B"
                            value={this.state.valorB}
                            onChange={this.myChangeHandler}
    					/>
                        <div class="input-field col s12">
                            <select 
                            className="browser-default"
                            name="operacao"
							value={this.state.operacao}
							onChange={this.myChangeHandler}>
           
                                <option value="soma">Adição</option>
                                <option value="subtracao">Subtração</option>
                                <option value="multiplicacao">Multiplicação</option>
                                <option value="divisao">Divisão</option>
                            </select>
                        </div>


                    </div>

                    <button className="button" type="submit">
						Calcular
					</button>
                </form>
                
            </div>
        );
    }
}

export default (Calculadora);