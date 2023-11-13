import React from "react";
import { useNavigate, useParams } from "react-router-dom";

export function withNavigation(Component) {
    return function WithNavigationProps(props) {
        let navigate = useNavigate();
        let params = useParams();

        return <Component {...props} navigate = {navigate} params = {params} />
    };
}