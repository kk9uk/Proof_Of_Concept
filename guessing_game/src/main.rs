use std::{
    cmp::Ordering,
    io::{self, Write},
};

use rand::Rng;

fn main() {
    println!("Guess THE number (1..=100)!");
    let the_number = rand::thread_rng().gen_range(1..=100);

    loop {
        print!("Input your guess: ");
        io::stdout().flush().unwrap();

        let mut guess = String::new();
        io::stdin().read_line(&mut guess).unwrap();
        let guess: u32 = match guess.trim().parse() {
            Ok(val) => val,
            Err(_) => continue,
        };

        match guess.cmp(&the_number) {
            Ordering::Less => println!("TOO SMALL!"),
            Ordering::Equal => {
                println!("YOU GOT IT!");
                break;
            }
            Ordering::Greater => println!("Take it easy..."),
        }
    }
}
