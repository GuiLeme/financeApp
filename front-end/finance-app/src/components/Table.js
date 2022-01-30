import React from "react";
import { useState, useEffect } from "react";
import axios from "axios"

const api = axios.create({
    baseURL: `http://localhost:8080`
})

// TODO: Agora tenho que mandar as linhas diferentes que servem para tipos de compras diferentes
// Gasolina, Mercado, e exibir o tipo, na primeira coluna, e o total na última

const Table = function () {
    
    const [isDataLoaded, setIsDataLoaded] = useState(false)
    const [tableContent, setTableContent] = useState(function (){
        api.get("/user/1").then((res) => {
            const list = res.data.cashFlows
            const newList = new Array(7)
            for (const i in list){
                const newItem = {...list[i], isActive: true}
                const dateOfItem = new Date(newItem.timestamp)
                newItem.key = dateOfItem.getDay() === 0 ? 6 : dateOfItem.getDay() - 1
                newList[newItem.key] = newItem
            }
            setTableContent([[], [...newList]])
        }).catch((e) => {console.log(e)})
        return null
    })

    useEffect(() => {
        if (tableContent != null) {
            setIsDataLoaded(true)
        }
    }, [tableContent]);

    const isHovering = (item) => {
        const table = tableContent
        table[1][item.key].isActive = false
    
        setTableContent([...table])
    }

    const leaveHovering = (item) => {
        const table = tableContent
        table[1][item.key].isActive = true

        setTableContent([...table])
    }

    
    return (
        <>
            <div className="table-selector">
                <div>
                    <i className="fas fa-redo"></i>
                </div>
                {isDataLoaded && 
                    <table>
                        <thead>
                            <tr>
                                <th>CashFlow</th>
                                <th>Monday</th>
                                <th>Tuesday</th>
                                <th>Wednesday</th>
                                <th>Thursday</th>
                                <th>Friday</th>
                                <th>Saturday</th>
                                <th>Sunday</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Gas</td>
                                {tableContent[1].map((item) => {
                                    if (item) {
                                        return (<td key={item.id} onMouseEnter={() => isHovering(item)} onMouseLeave={() => {leaveHovering(item)}}>{
                                            item.isActive 
                                            ? <>{item.price}<br/>{item.name}</> 
                                            : <button><i className="fas fa-plus"></i></button>
                                            }
                                        </td>)
                                    }else{
                                        return(<td></td>)
                                    }
                                })}
                                <td>CashFlow</td>
                            </tr>
                        </tbody>
                    </table>
                }   
            </div>
        </>
    )
}

export default Table