import React from "react";

const Header = function () {
    return (
        <>
            <div className="flex-container header">
                <h1 className="emphasis">
                    <span>Fin</span> Org
                </h1>
                <div className="menu">
                    <button className="b-add">Add</button>
                    <a href="#">Home</a>
                    <a href="#" id="premium">Be Premium</a>
                    <a href="#">About us</a>
                </div>
            </div>
        </>
    )
}

export default Header