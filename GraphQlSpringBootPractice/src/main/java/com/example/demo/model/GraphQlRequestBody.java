/**
 * 
 */
package com.example.demo.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphQlRequestBody {
	private String query;
	private String operationName;
	private Map<String, Object> varibles;
}
