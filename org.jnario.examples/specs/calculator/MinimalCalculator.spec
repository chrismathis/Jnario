package calculator

describe Calculator "- A minimal Spec" {
	
	- [subject.add(4, 5) => 9]
	- [subject.divide(10, 5) => 1]
	- throws ArithmeticException [subject.divide(10, 0)]
	- [ #(1, 2, 3) ]

}                                          